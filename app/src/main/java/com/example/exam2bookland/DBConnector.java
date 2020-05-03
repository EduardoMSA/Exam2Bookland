package com.example.exam2bookland;

import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBConnector {
    private String category;
    private static final String TAG = "DBConnector";

    public DBConnector(String category) {
        this.category = category;
        Log.i(TAG,"Initiated");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String enviarDatosGET(){
        URL url = null;
        String linea= "";
        int respuesta = 0;
        StringBuilder resul = null;


        try {
            url = new URL("https://androidstorepddm.000webhostapp.com/services/getbooks.php?category="+this.category);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            respuesta = connection.getResponseCode();

            resul = new StringBuilder();

            if (respuesta==HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                    resul.append(linea);
                }
            }
        } catch (Exception e){
            Log.e(TAG,e.toString());
        }

        return resul.toString();
    }

    public int obtDatosJSON(String response){
        int res=0;
        try {
            JSONArray json = new JSONArray(response);
            if(json.length()>0){
                res=1;
            }
        } catch (Exception e){

        }
        return res;
    }
}
