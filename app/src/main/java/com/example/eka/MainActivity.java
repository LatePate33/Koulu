package com.example.eka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        System.out.println("KANSIO" + context.getFilesDir());

    }

    public void read(View v) {
        try {
            InputStream ins = context.openFileInput(tiedostonimi.getText().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";

            while ((s=br.readLine()) != null) {
                teksti.setText(s);
            }
            ins.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("LUETTU");
        }
    }

    public void write(View v) {
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput(tiedostonimi.getText().toString(), Context.MODE_PRIVATE));
            String s = "";
            s += teksti.getText();
            ows.write(s);
            ows.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            System.out.println("KIRJOITETTU");
        }
    }

}
