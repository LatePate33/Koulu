package com.example.eka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainActivity extends AppCompatActivity {

    TextView teksti;
    TextView teksti2;
    SeekBar slider;
    Spinner valikko;
    Context context = null;
    ArrayAdapter<String> adapter;
    BottleDispenser bottle = BottleDispenser.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teksti = (TextView) findViewById(R.id.textView);
        slider = (SeekBar) findViewById(R.id.seekBar);
        teksti2 = (TextView) findViewById(R.id.textView2);
        valikko = (Spinner) findViewById(R.id.spinner);
        context = MainActivity.this;
        ArrayList<String> arraySpinner = bottle.listBottles();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        valikko.setAdapter(adapter);
    }

    public void lisaa(View v) {
        int i = slider.getProgress();
        bottle.addMoney(teksti, i);
        slider.setProgress(0);
    }

    public void palauta(View v) {
        bottle.returnMoney(teksti);
    }

    public void osta(View v) throws IOException {
        int text = valikko.getSelectedItemPosition();
        System.out.println(text);
        bottle.buyBottle(teksti, text, context);

    }



}

