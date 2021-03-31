package com.example.atividadedois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.example.atividadedois.model.Albums;

public class DetalheAlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_albums);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objAlbums");

        Albums albums = intent.getParcelableExtra("objAlbums");
        populaTelaAlbums(albums);
    }

    private void populaTelaAlbums(Albums obj){
        TextView tv = findViewById(R.id.tvId_Albums);
        tv.setText(obj.getId()+"");

        tv = findViewById(R.id.tvIdUser_Albums);
        tv.setText(obj.getUserId()+"");

        tv = findViewById(R.id.tvTitle_Albums);
        tv.setText(obj.getTitle()+"");

    }

}