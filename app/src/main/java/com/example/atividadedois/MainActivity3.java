package com.example.atividadedois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.atividadedois.model.Albums;
import com.example.atividadedois.model.Posts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ArrayList<Posts> posts = new ArrayList<Posts>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,this::onResponse, this::onErrorResponse);

        queue.add(jsonArrayRequest);
    }


    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i<response.length();i++){
                JSONObject json = response.getJSONObject(i);

                Posts obj = new Posts (json.getInt("userId"), json.getInt("id"), json.getString("title"), json.getString("body"));
                posts.add(obj);
            }

            for(Posts obj1 : posts){
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        Button btn = (Button) v;
                        Posts posts = (Posts) btn.getTag();

                        Intent intent = new Intent (getApplicationContext(), DetalhePostsActivity.class);

                        intent.putExtra("objPosts", posts);
                        startActivity(intent);

                        //Toast.makeText(v.getContext(),albums.getId()+" - "+albums.getTitle(), Toast.LENGTH_LONG).show();
                    }
                });
                ((LinearLayout)findViewById(R.id.layoutItens)).addView(bt);
            }

        }catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }


    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(),"erro",Toast.LENGTH_LONG).show();
    }

    public void cliqueBt(View view){

        Intent intent = new Intent(this, MainActivity4.class);

        startActivity(intent);
    }
}