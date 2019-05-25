package com.example.myapplication_vibrate;

import android.content.Context;
import android.os.Environment;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textviewResult;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean result = isExternalSrorageWritable();
        textviewResult = (TextView)findViewById(R.id.textviewResult);
        textviewResult.setText("Result : " + result);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    public static boolean isExternalSrorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        vibrator.vibrate(1000);
    }
}





