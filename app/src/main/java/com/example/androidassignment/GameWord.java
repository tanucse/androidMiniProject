package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameWord extends AppCompatActivity implements View.OnClickListener {

    TextView info, word;
    EditText ans;
    Button check;
    Random r;
    String array[];
    String currentWord;
    int count=0,score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_word);
        info = findViewById(R.id.info);
        word = findViewById(R.id.word);
        ans = findViewById(R.id.ans);
        check = findViewById(R.id.check);
        check.setOnClickListener(this);
        r = new Random();
        Bundle b = getIntent().getExtras();

        array = b.getStringArray("array");
        createWord();
    }
    @Override
    public void onClick(View v)
    {
        checkWord();
        if(count<11)
        {
            createWord();
        }
        else
        {
            word.setText("Your Final Score:"+score);
        }
    }

    private String jummbleWord(String word)
    {
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = " ";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }

    private  void createWord() {
        count++;
        ans.setText("");
        currentWord = array[r.nextInt(array.length)];
        word.setText(jummbleWord(currentWord));
        Toast.makeText(this, "Fill The Answer", Toast.LENGTH_SHORT).show();
        ans.setText("");
    }

    private void checkWord()
    {

        if (ans.getText().toString().equalsIgnoreCase(currentWord)) {
            score++;
            Toast.makeText(this, "Awesome", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "Opps!! Wrong Answer, Try Next", Toast.LENGTH_SHORT).show();
        }
    }

}

