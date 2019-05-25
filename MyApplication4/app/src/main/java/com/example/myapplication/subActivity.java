package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class subActivity extends AppCompatActivity {
    TextView IDtext;
    TextView PWtext;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        intent = getIntent();

        IDtext = (TextView)findViewById(R.id.IDword);
        PWtext = (TextView)findViewById(R.id.PWord);


        String ID = intent.getStringExtra("ID");
        String PW = intent.getStringExtra("PW");

        IDtext.setText(ID);
        PWtext.setText(PW);
    }
}



