package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zero, one, two, three, four, five, six, seven, eight, nine;
    Button sum, minus, division, multiplication, result, reset;
    EditText edit;
    TextView ing;

    float value1, value2;
    String value_history = "";
    int symbol = 0;
    float result_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        sum = (Button) findViewById(R.id.sum);
        minus = (Button) findViewById(R.id.minus);
        division = (Button) findViewById(R.id.division);
        multiplication = (Button) findViewById(R.id.multiplication);
        reset = (Button) findViewById(R.id.AC);
        result = (Button) findViewById(R.id.equals);
        edit = (EditText) findViewById(R.id.edit);
        ing = (TextView) findViewById(R.id.ing);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        sum.setOnClickListener(this);
        minus.setOnClickListener(this);
        division.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        result.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero:
                edit.setText(edit.getText().toString() + 0);
                break;
            case R.id.one:
                edit.setText(edit.getText().toString() + 1);
                break;
            case R.id.two:
                edit.setText(edit.getText().toString() + 2);
                break;
            case R.id.three:
                edit.setText(edit.getText().toString() + 3);
                break;
            case R.id.four:
                edit.setText(edit.getText().toString() + 4);
                break;
            case R.id.five:
                edit.setText(edit.getText().toString() + 5);
                break;
            case R.id.six:
                edit.setText(edit.getText().toString() + 6);
                break;
            case R.id.seven:
                edit.setText(edit.getText().toString() + 7);
                break;
            case R.id.eight:
                edit.setText(edit.getText().toString() + 8);
                break;
            case R.id.nine:
                edit.setText(edit.getText().toString() + 9);
                break;
            case R.id.point:
                edit.setText(edit.getText().toString() + .);
                break;
            case R.id.sum:
                value = Float.valueOf(edit.getText().toString().trim());
                value_history = value_history + edit.getText().toString() + '+';
                ing.setText(value_history);
                result_f = value + Float.valueOf(edit.getText().toString().trim());
                edit.setText("");
                symbol = 1;
                break;
            case R.id.minus:
                value = Float.valueOf(edit.getText().toString().trim());
                value_history = value_history + edit.getText().toString() + '-';
                ing.setText(value_history);
                result_f = value - Float.valueOf(edit.getText().toString().trim());
                edit.setText("");
                symbol = 2;
                break;
            case R.id.division:
                value = Float.valueOf(edit.getText().toString().trim());
                value_history = value_history + edit.getText().toString() + '÷';
                ing.setText(value_history);
                result_f = value / Float.valueOf(edit.getText().toString().trim());
                edit.setText("");
                symbol = 3;
                break;
            case R.id.multiplication:
                value = Float.valueOf(edit.getText().toString().trim());
                value_history = value_history + edit.getText().toString() + '×';
                ing.setText(value_history);
                result_f = value * Float.valueOf(edit.getText().toString().trim());
                edit.setText("");
                symbol = 4;
                break;
            case R.id.equals:
                value = Float.valueOf(edit.getText().toString().trim());
                value_history = value_history + edit.getText().toString() + '=';
                ing.setText(value_history);
                if (symbol == 1){
                    result_f = value + Float.valueOf(edit.getText().toString().trim());
                    edit.setText(Float.toString(result_f));
                }else if (symbol == 2){
                    result_f = value - Float.valueOf(edit.getText().toString().trim());
                    edit.setText(Float.toString(result_f));
                }else if (symbol == 3){
                    result_f = value / Float.valueOf(edit.getText().toString().trim());
                    edit.setText(Float.toString(result_f));
                }else if (symbol == 4){
                    result_f = value * Float.valueOf(edit.getText().toString().trim());
                    edit.setText(Float.toString(result_f));
                }
                break;
            case R.id.AC:
                value = 0;
                symbol = 0;
                result_f = 0;
                value_history = "";
                ing.setText("");
                edit.setText("");

        }
    }
}
