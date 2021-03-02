package com.example.eka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.Scanner;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText tiedostonimi, teksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        tiedostonimi = findViewById(R.id.tiedosto);
        teksti = findViewById(R.id.Alusta);

    }

    public void read(View v) {
        try {
            InputStream ins = context.openFileInput(String.valueOf(tiedostonimi));

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = String.valueOf(teksti);

            while ((s=br.readLine()) != null) {
                
            }

        }
    }

}
