package com.example.exam2bookland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MailActivity extends AppCompatActivity {

    private EditText cc, subject, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        this.cc = findViewById(R.id.ccEditText);
        this.subject = findViewById(R.id.subjectEditText);
        this.msg = findViewById(R.id.msgEditText);
    }

    public void send(View view){
        String[] TO = {"edmendez98@gmail.com"};
        String[] CC = {this.cc.getText().toString()};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, this.subject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, this.msg.getText().toString());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Email Send", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
