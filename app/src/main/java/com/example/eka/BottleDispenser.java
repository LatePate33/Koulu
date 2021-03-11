package com.example.eka;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;

class BottleDispenser {
    private static BottleDispenser single_instance = null;
    private int bottles;
    private final ArrayList<Bottle> bottle_array;
    private float money;


    public static BottleDispenser getInstance() {
        if (single_instance == null) {
            single_instance = new BottleDispenser();
        }
        return single_instance;
    }

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        bottle_array = new ArrayList<Bottle>(bottles);
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.8, 0.5, 1));
        bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 2.2, 1.5, 1));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.0, 0.5, 1));
        bottle_array.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.5, 1.5, 1));
        bottle_array.add(new Bottle("Fanta Zero", "Coca-Cola", 0.3, 1.95, 0.5, 2));
    }

    public void addMoney(TextView sana, int i) {
        money += i;
        String s = "Klink! Added more money: " + money;
        sana.setText(s);
    }

    public void buyBottle(TextView sana, int i, Context c) {

        if (bottle_array.get(i).getNumber() == 0) {
            String s = "No more bottles!";
            sana.setText(s);
        } else {
            Bottle bottle = bottle_array.get(i);
            if (money < bottle.getPrice()) {
                String s = "Add money first!";
                sana.setText(s);
            } else {
                bottles -= 1;
                money -= bottle.getPrice();
                int number = bottle.getNumber();
                number--;
                bottle_array.set(i, new Bottle(bottle.getName(),bottle.getManufacturer(),bottle.getEnergy(),bottle.getPrice(),bottle.getSize(), number));
                String s = "KACHUNK! " + bottle.getName() + " came out of the dispenser!";
                sana.setText(s);
                try {
                    String k = "Receipt! " + bottle.getName() + " " + bottle.getPrice() + " €";
                    OutputStreamWriter ows = new OutputStreamWriter(c.openFileOutput("Kuitti.txt", Context.MODE_PRIVATE));
                    ows.write(k);
                    ows.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void returnMoney(TextView sana) {
        String s = "Klink Klink. Money came out! You got " + money + " € back.";
        sana.setText(s);
        money = 0;
    }


    public ArrayList<String> listBottles() {
        ArrayList<String> arraySpinner = new ArrayList<String> ();
        for (int i = 0; i < bottles; i++) {
            Bottle b = bottle_array.get(i);
            String nimi = b.getName();
            double koko = b.getSize();
            String kokos = String.valueOf(koko);
            arraySpinner.add(nimi + ", Size: " + kokos);
        }

        return arraySpinner;
    }

}

