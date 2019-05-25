package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText EDID;
    public EditText EDPW;
    public Button BT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EDID = (EditText)findViewById(R.id.editTextID);
        EDPW = (EditText)findViewById(R.id.editTextPW);
        BT = (Button)findViewById(R.id.button);
        BT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, subActivity.class);
        intent.putExtra("ID", EDID.getText().toString());
        intent.putExtra("PW", EDPW.getText().toString());
        startActivity(intent);
    }
}


