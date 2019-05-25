package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  number;
    EditText  name;
    EditText  phone;
    Button button;
    TextView result;
    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText)findViewById(R.id.editTextNum);
        name = (EditText)findViewById(R.id.textName);
        phone = (EditText)findViewById(R.id.editTextPhone);
        button = (Button)findViewById(R.id.button);
        result = (TextView)findViewById(R.id.textView);
        button.setOnClickListener(this);
        sqliteDB = openOrCreateDatabase("sample.db", Context.MODE_PRIVATE, null);

        if (sqliteDB != null) {
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + "CONTACT_T (" + "STNO INTEGER NOT NULL, " + "NAME TEXT, " + "PHONE TEXT)";
            sqliteDB.execSQL(sqlCreateTable);
        }
    }

    @Override
    public void onClick(View v) {

        String inputnumber = number.getText().toString();
        String inputname = name.getText().toString();
        String inputphone = phone.getText().toString();

        String sqlInsert = "INSERT INTO CONTACT_T(STNO, NAME, PHONE) VALUES (" + inputnumber + ", '" + inputname + "', '" + inputphone + "')";
        sqliteDB.execSQL(sqlInsert);

        String sqlSelect = "SELECT * FROM CONTACT_T";
        Cursor cursor = null;
        cursor = sqliteDB.rawQuery(sqlSelect, null);

        String tableData = "";
        while (cursor.moveToNext()) {
            int resultno = cursor.getInt(0);
            String resultname = cursor.getString(1);
            String resultphone = cursor.getString(2);
            tableData = tableData + resultno + ", " + resultname + ", " + resultphone + "\n";

        }
        result.setText(tableData);
    }
}

