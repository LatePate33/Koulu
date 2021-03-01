package com.example.eka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView2);
        text2 = (EditText) findViewById(R.id.syotto);

    }


    public void print(View v) {
        String sana = "";
        sana += text2.getText();
        text.setText(sana);
    }

}