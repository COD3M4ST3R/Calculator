package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ADS
        MobileAds.initialize(this, new OnInitializationCompleteListener()
        {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus)
            {

            }
        });

        // SPLASH SCREEN
        Thread timerThread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);

                }catch(InterruptedException e)
                {
                    e.printStackTrace();

                }finally
                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        };
        timerThread.start();
    }
}
