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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.atividadedois.model.Albums;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Response.ErrorListener {

    ArrayList<Albums> albums = new ArrayList<Albums>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/albums";


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,this::onResponse, this::onErrorResponse);

        queue.add(jsonArrayRequest);
    }


    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i<response.length();i++){
                JSONObject json = response.getJSONObject(i);

                Albums obj = new Albums(json.getInt("userId"), json.getInt("id"), json.getString("title"));
                albums.add(obj);
            }

            for(Albums obj1 : albums){
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        Button btn = (Button) v;
                        Albums albums = (Albums) btn.getTag();

                        Intent intent = new Intent (getApplicationContext(), DetalheAlbumsActivity.class);

                        intent.putExtra("objAlbums", albums);
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

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this.getApplicationContext(),"erro",Toast.LENGTH_LONG).show();
    }

    public void cliqueBt(View view){

        Intent intent = new Intent(this, MainActivity3.class);

        startActivity(intent);
    }
}
