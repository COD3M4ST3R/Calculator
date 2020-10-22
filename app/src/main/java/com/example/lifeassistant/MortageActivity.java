package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MortageActivity extends AppCompatActivity
{
    // VARIABLES
    double payment, interestRate;
    double function;
    int principal, time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortage);

        // INITIALIZE AND CASTING
        final EditText editText13 = (EditText)findViewById(R.id.editText13);
        final EditText editText14 = (EditText)findViewById(R.id.editText14);
        final EditText editText15 = (EditText)findViewById(R.id.editText15);
        final TextView textView36 = (TextView)findViewById(R.id.textView36);
        Button button24 = (Button)findViewById(R.id.button24);
        Button button25 = (Button)findViewById(R.id.button25);

        // ADS
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);


        // CALCULATE BUTTON ONCLICK
        button24.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                principal = Integer.parseInt(editText13.getText().toString());
                interestRate = Double.parseDouble(editText14.getText().toString());
                time = Integer.parseInt(editText15.getText().toString());
                interestRate = interestRate / 1200;
                time = time * 12;
                function = Math.pow(1+interestRate, time);
                payment = principal * ((interestRate * function) /(function - 1));

                textView36.setText("Montly Payment: " + payment);
            }
        });

        button25.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText13.setText("");
                editText14.setText("");
                editText15.setText("");
                textView36.setText("");
            }
        });
    }
}
