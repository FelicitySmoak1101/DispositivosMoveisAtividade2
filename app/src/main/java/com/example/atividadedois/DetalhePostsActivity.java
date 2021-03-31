package com.example.atividadedois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.atividadedois.model.Albums;
import com.example.atividadedois.model.Posts;

public class DetalhePostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_posts);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objPosts");

        Posts posts = intent.getParcelableExtra("objPosts");
        populaTelaPosts(posts);
    }

    private void populaTelaPosts(Posts obj){
        TextView tv = findViewById(R.id.tvId_Posts);
        tv.setText(obj.getId()+"");

        tv = findViewById(R.id.tvIdUser_Posts);
        tv.setText(obj.getUserId()+"");

        tv = findViewById(R.id.tvTitle_Posts);
        tv.setText(obj.getTitle()+"");

        tv = findViewById(R.id.tvBody_Posts);
        tv.setText(obj.getBody()+"");

    }

}