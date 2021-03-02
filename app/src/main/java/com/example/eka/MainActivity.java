package com.example.eka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.Scanner;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        text = (TextView) findViewById(R.id.textView2);
        text2 = (EditText) findViewById(R.id.syotto);
        if (keyCode == KEYCODE_ENTER) {
            print();
        }
        return true;
    }


    public void print() {
        String sana = "";
        sana += text2.getText();
        text.setText(sana);
    }
}
