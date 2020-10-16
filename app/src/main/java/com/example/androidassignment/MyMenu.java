package com.example.androidassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyMenu extends Activity implements AdapterView.OnItemClickListener {

    String[] ar = {"Calculator","TicTacToe","JumbleWordGame","StudentManagement","Quiz","SongList"};

    ArrayAdapter<String> ad;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menu);
        ad = new ArrayAdapter<String>(this, R.layout.mylistviewdesign,R.id.lvdesign,ar);
        lv=findViewById(R.id.list);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            String s = "com.example.androidassignment." + ar[position];
            Class c = Class.forName(s);
            Intent intent = new Intent(MyMenu.this, c);
            startActivity(intent);
        }

        catch (Exception e)
        {


        }
    }
}