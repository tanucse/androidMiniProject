package com.example.androidassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity implements View.OnClickListener {
    Button insert, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.insert);
        show = findViewById(R.id.show);
        insert.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                Intent i = new Intent(this, Quiz.class);
                startActivity(i);
                break;
            case R.id.show:
                Intent j = new Intent(this, ShowData.class);
                startActivity(j);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
