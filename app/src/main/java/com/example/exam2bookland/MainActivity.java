package com.example.exam2bookland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickArt(View view){
        final DBConnector db = new DBConnector("art");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),artActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickComics(View view){
        final DBConnector db = new DBConnector("comics");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),comicActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickEnglish(View view){
        final DBConnector db = new DBConnector("english");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),englishActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickScifi(View view){
        final DBConnector db = new DBConnector("scifi");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),scifiActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickSelf(View view){
        final DBConnector db = new DBConnector("self");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),selfActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickSports(View view){
        final DBConnector db = new DBConnector("sports");
        Thread tr = new Thread(){
            @Override
            public void run() {
                final String result = db.enviarDatosGET();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent art = new Intent(getApplicationContext(),sportsActivity.class);
                        art.putExtra("data",result);
                        startActivity(art);
                    }
                });

            }
        };

        tr.start();

    }
    public void clickFind(View view){
        Intent map = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(map);
    }
    public void clickEmail(View view){
        Intent mail = new Intent(getApplicationContext(),MailActivity.class);
        startActivity(mail);

    }
}
