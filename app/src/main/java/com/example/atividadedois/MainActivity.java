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
import com.example.atividadedois.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{
    ArrayList<Todo> todos = new ArrayList<Todo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/todos";


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,this, this);

        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i<response.length();i++){
                JSONObject json = response.getJSONObject(i);

                Todo obj = new Todo(json.getInt("userId"), json.getInt("id"), json.getString("title"), json.getBoolean("completed"));
                todos.add(obj);
            }

            for(Todo obj1 : todos){
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        Button btn = (Button) v;
                        Todo todo = (Todo) btn.getTag();

                       Intent intent = new Intent (getApplicationContext(), DetalheTodoActivity.class);

                       intent.putExtra("objTodo", todo);
                       startActivity(intent);

                        //Toast.makeText(v.getContext(),todo.getId()+" - "+todo.getTitle(), Toast.LENGTH_LONG).show();
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

        Intent intent = new Intent(this, MainActivity2.class);

        startActivity(intent);
    }
}