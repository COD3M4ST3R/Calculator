package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdvancedMathActivity extends AppCompatActivity
{
    double number;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_math);

        // INITIALIZE AND CAST VARIABLES

        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        Button button = (Button) findViewById(R.id.button);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button13 = (Button) findViewById(R.id.button13);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button16 = (Button) findViewById(R.id.button16);
        Button button14 = (Button) findViewById(R.id.button14);
        Button button15 = (Button) findViewById(R.id.button15);
        Button button12 = (Button) findViewById(R.id.button12);
        Button button11 = (Button) findViewById(R.id.button11);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        // ADS
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.sin(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.cos(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.tan(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.asin(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.acos(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.atan(number);
                textView4.setText(String.valueOf(result));

                Toast.makeText(AdvancedMathActivity.this, "RADIAN VALUE", Toast.LENGTH_SHORT).show();
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.log(number);
                textView4.setText(String.valueOf(result));
            }
        });

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.log10(number);
                textView4.setText(String.valueOf(result));
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.log1p(number);
                textView4.setText(String.valueOf(result));
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.cbrt(number);
                textView4.setText(String.valueOf(result));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.exp(number);
                textView4.setText(String.valueOf(result));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Double.parseDouble(editText3.getText().toString());
                result = Math.sqrt(number);
                textView4.setText(String.valueOf(result));
            }
        });
    }
}
