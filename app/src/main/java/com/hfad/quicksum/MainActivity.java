package com.hfad.quicksum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    double score = 0;
    String text;
    TextView result;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Boolean otherPressed = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        text = getString(R.string.default_Value, score);
        result.setText(text);

    }

    public void addNumber(View view){
        button = findViewById(view.getId());
        double currentValue = Double.parseDouble(result.getText().toString());
        double numberSelected = 0;

        if (otherPressed){
            switch (view.getId()){
                case R.id.button1: numberSelected = 0.5;
                break;

                case R.id.button2: numberSelected = 0.33;
                break;

                case R.id.button3: numberSelected = 0.25;
                break;
            }
            resetButtons();
        }

        else {
            numberSelected = Double.parseDouble(button.getText().toString());
        }

        score = currentValue + numberSelected;
        text = getString(R.string.default_Value, score);
        result.setText(String.valueOf(text));
    }

    public void onPressOther(View view){
        otherPressed = true;
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setText("1/2");
        button2.setText("1/3");
        button3.setText("1/4");
    }

    public void resetButtons(){
        otherPressed = false;
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");

    }
}
