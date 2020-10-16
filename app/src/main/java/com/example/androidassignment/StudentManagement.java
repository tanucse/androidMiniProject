package com.example.androidassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentManagement extends AppCompatActivity {
    EditText name,roll,add,branch,email;
    Button reg,show;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    Student s;
    int max=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_management);
        name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);
        add=findViewById(R.id.add);
        branch=findViewById(R.id.branch);
        email=findViewById(R.id.email);
        reg=findViewById(R.id.reg);
        show=findViewById(R.id.show);
        s = new Student();
        dbr= fd.getInstance().getReference().child("StudentDetails");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                max=(int)snapshot.getChildrenCount();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setName(name.getText().toString());
                s.setRoll(roll.getText().toString());
                s.setAddress(add.getText().toString());
                s.setBranch(branch.getText().toString());
                s.setEmail(email.getText().toString());
                dbr.child(String.valueOf(max+1)).setValue(s);
                reset();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentManagement.this,ShowData.class);
                startService(intent);
            }
        });
    }
    void reset()
    {
        name.setText("");
        add.setText("");
        roll.setText("");
        branch.setText("");
        email.setText("");
    }
}

