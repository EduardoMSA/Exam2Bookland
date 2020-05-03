package com.example.exam2bookland;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity {
    private long ms = 0;
    private long splashTime = 2000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread(){
            @Override
            public void run() {
                try{
                    while(splashActive && ms < splashTime){
                        if(!paused){
                            ms+=100;
                        }
                        sleep(100);
                    }
                } catch (Exception e){}
                finally {
                    Intent login = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(login);
                }
            }
        };

        t.start();


    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }


}