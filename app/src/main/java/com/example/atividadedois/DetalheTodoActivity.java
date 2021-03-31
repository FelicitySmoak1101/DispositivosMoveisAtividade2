package com.example.atividadedois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.atividadedois.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objTodo");

        Todo todo = intent.getParcelableExtra("objTodo");
        populaTela(todo);
   }

   private void populaTela(Todo obj){
        TextView tv = findViewById(R.id.tvId_Albums);
        tv.setText(obj.getId()+"");

        tv = findViewById(R.id.tvIdUser_Albums);
        tv.setText(obj.getUserId()+"");

        tv = findViewById(R.id.tvTitle_Albums);
        tv.setText(obj.getTitle()+"");

        CheckBox cb = findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());
   }
}