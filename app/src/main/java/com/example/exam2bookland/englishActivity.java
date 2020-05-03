package com.example.exam2bookland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class englishActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBooks;
    private RecyclerViewAdapter adapterBooks;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        this.recyclerViewBooks = (RecyclerView) findViewById(R.id.recyclerArt);
        this.recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));

        this.adapterBooks=new RecyclerViewAdapter(getBooks(),this);
        this.recyclerViewBooks.setAdapter(this.adapterBooks);



    }

    public List<BookModelo> getBooks(){
        List<BookModelo> books = new ArrayList<>();
        try {
            JSONArray booksArray = new JSONArray(getIntent().getStringExtra("data"));
            for (int i = 0; i < booksArray.length(); i++){
                JSONArray array = booksArray.getJSONArray(i);
                JSONObject object = array.getJSONObject(0);
                Log.i("Titulo",object.getString("title"));
                books.add(new BookModelo(object.getString("title"),object.getString("author"),object.getString("category"),object.getString("editorial"),object.getString("description"),object.getString("price"),object.getString("url_picture")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return books;
    }
}
