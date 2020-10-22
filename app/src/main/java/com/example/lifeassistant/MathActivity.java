package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MathActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        ImageView imageView10 = (ImageView) findViewById(R.id.imageView10);

        imageView10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openAdvancedMathActivity();
            }
        });

        // ADS
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        // PLUS
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float num1 = Float.parseFloat(editText.getText().toString());
                float num2 = Float.parseFloat(editText2.getText().toString());
                float result = num1 + num2;
                textView2.setText(String.valueOf(result));
            }
        });

        // DIVIDE
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                float num1 = Float.parseFloat(editText.getText().toString());
                float num2 = Float.parseFloat(editText2.getText().toString());
                float result = num1 / num2;
                textView2.setText(String.valueOf(result));
            }
        });

        // SUB
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float num1 = Float.parseFloat(editText.getText().toString());
                float num2 = Float.parseFloat(editText2.getText().toString());
                float result = num1 - num2;
                textView2.setText(String.valueOf(result));
            }
        });

        // MULTIPLY
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float num1 = Float.parseFloat(editText.getText().toString());
                float num2 = Float.parseFloat(editText2.getText().toString());
                float result = num1 * num2;
                textView2.setText(String.valueOf(result));
            }
        });
    }

    public void openAdvancedMathActivity()
    {
        Intent intent_AdvancedMath = new Intent(this, AdvancedMathActivity.class);
        startActivity(intent_AdvancedMath);
    }
}