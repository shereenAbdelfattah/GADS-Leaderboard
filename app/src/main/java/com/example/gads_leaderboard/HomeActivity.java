package com.example.gads_leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setSplashScreen();
    }

    private void setSplashScreen() {
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }; thread.start();

    }

/*
    private void setSplashScreen() {
        Thread thread = new Thread(){

            Intent intent = new Intent(HomeActivity.this,MainActivity.class);
           // startActivity(intent);
            */
/*
                sleep(4000);

                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            *//*

        };thread.start();



    }
*/
}