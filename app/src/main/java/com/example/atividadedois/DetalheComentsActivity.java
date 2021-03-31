package com.example.atividadedois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.example.atividadedois.model.Albums;
import com.example.atividadedois.model.Coments;

public class DetalheComentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_coments);

        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objComents");

        Coments coments = intent.getParcelableExtra("objComents");
        populaTelaComents(coments);
    }

    private void populaTelaComents(Coments obj){
        TextView tv = findViewById(R.id.tvId_Coments);
        tv.setText(obj.getId()+"");

        tv = findViewById(R.id.tvIdPost_Coments);
        tv.setText(obj.getPostId()+"");

        tv = findViewById(R.id.tvName_Coments);
        tv.setText(obj.getName()+"");

        tv = findViewById(R.id.tvEmail_Coments);
        tv.setText(obj.getEmail()+"");

        tv = findViewById(R.id.tvBody_Coments);
        tv.setText(obj.getBody()+"");

    }

}