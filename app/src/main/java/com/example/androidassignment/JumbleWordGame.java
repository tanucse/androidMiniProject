package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JumbleWordGame extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button city,animal,flower,state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble_word_game);
        tv=findViewById(R.id.choose);
        city=findViewById(R.id.city);
        flower=findViewById(R.id.flower);
        state=findViewById(R.id.state);
        animal=findViewById(R.id.animal);
        animal.setOnClickListener(this);
        state.setOnClickListener(this);
        city.setOnClickListener(this);
        flower.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.animal:
                String animal[] ={"LION", "TIGER", "ELEPHANT", "RHINO", "WOLF", "BEAR", "PANTHER", "LEOPARD",
                        "MONKEY", "CHEETAH", "DEAR"};
                Intent i= new Intent(this, GameWord.class);
                Bundle b=new Bundle();
                b.putStringArray("array", animal);
                i.putExtras(b);
                startActivity(i);
                break;


            case R.id.city:
                String array[] ={"DELHI", "DEHRADUN", "LUCKNOW", "MUMBAI", "PATNA", "PUNE", "GAYA", "KOLKATA",
                        "KANPUR", "HAZIPUR", "HYDERABAD"};
                Intent i1= new Intent(this, GameWord.class);
                Bundle b1=new Bundle();
                b1.putStringArray("array", array);
                i1.putExtras(b1);
                startActivity(i1);
                break;


            case R.id.flower:
                String flower[] ={"ROSE", "PANSY", "DAISY", "HIBISCUS", "LILY", "DAFFODIL", "LOTUS", "JASMINE",
                        "FORGETMENOT", "LAVENDER", "POPPY"};
                Intent i2= new Intent(this, GameWord.class);
                Bundle b2=new Bundle();
                b2.putStringArray("array", flower);
                i2.putExtras(b2);
                startActivity(i2);
                break;


            case R.id.state:
                String state[] ={"DELHI", "BIHAR", "JHARKHAND", "MAHARASTRA", "WESTBENGAL", "ORRISA", "TAMILNADU", "KERELA",
                        "DEHRADUN", "HARYANA", "GUJRAT"};
                Intent i3= new Intent(this, GameWord.class);
                Bundle b3=new Bundle();
                b3.putStringArray("array", state);
                i3.putExtras(b3);
                startActivity(i3);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());

        }
    }
}

