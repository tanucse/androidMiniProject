package com.example.androidassignment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder extends RecyclerView.ViewHolder {
    View view;
    public DataHolder(@NonNull View itemView) {
        super(itemView);
        view =itemView;
    }
    public void setView(Context context,String name,String roll,String add,String email,String branch)
    {
        TextView sname=view.findViewById(R.id.name);
        TextView sroll=view.findViewById(R.id.roll);
        TextView sadd=view.findViewById(R.id.add);
        TextView semail=view.findViewById(R.id.email);
        TextView sbranch=view.findViewById(R.id.branch);
        sname.setText(name);
        sroll.setText(roll);
        sadd.setText(add);
        semail.setText(email);
        sbranch.setText(branch);




    }

}

