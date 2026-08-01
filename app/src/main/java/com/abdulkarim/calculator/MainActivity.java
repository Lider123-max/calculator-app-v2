package com.abdulkarim.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView display;
    double firstValue = 0;
    String pendingOp = null;
    boolean startNewNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    public void onDigit(View v) {
        String digit = ((Button) v).getText().toString();
        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText().toString() + digit);
        }
    }

    public void onOperator(View v) {
        firstValue = Double.parseDouble(display.getText().toString());
        pendingOp = ((Button) v).getText().toString();
        startNewNumber = true;
    }

    public void onEquals(View v) {
        if (pendingOp == null) return;
        double secondValue = Double.parseDouble(display.getText().toString());
        double result = 0;
        switch (pendingOp) {
            case "+": result = firstValue + secondValue; break;
            case "-": result = firstValue - secondValue; break;
            case "*": result = firstValue * secondValue; break;
            case "/": result = secondValue != 0 ? firstValue / secondValue : 0; break;
        }
        display.setText(String.valueOf(result));
        pendingOp = null;
        startNewNumber = true;
    }

    public void onClear(View v) {
        display.setText("0");
        firstValue = 0;
        pendingOp = null;
        startNewNumber = true;
    }
}
