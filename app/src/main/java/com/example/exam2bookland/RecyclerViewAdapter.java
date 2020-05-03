package com.example.exam2bookland;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, author, editorial, price;
        ImageView book;
        public ViewHolder(View view){
            super(view);
            this.title = view.findViewById(R.id.titleTextView);
            this.author = view.findViewById(R.id.authorTextView);
            this.editorial = view.findViewById(R.id.editorialTextView);
            this.price = view.findViewById(R.id.priceTextView);
            this.book = view.findViewById(R.id.imageBook);
        }
    }

    private List<BookModelo> books;
    private Context context;

    public RecyclerViewAdapter(List<BookModelo> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(books.get(position).getTitle());
        holder.author.setText(books.get(position).getAuthor());
        holder.editorial.setText(books.get(position).getEditorial());
        holder.price.setText(books.get(position).getPrice());
        Picasso.get().load(books.get(position).getUrl()).into(holder.book);

        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context).setTitle(books.get(position).getTitle()).setMessage(books.get(position).getDescription()).setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
