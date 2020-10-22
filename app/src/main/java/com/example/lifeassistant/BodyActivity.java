package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BodyActivity extends AppCompatActivity
{
    // VARIABLES
    double weight, height, result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        // INITIALIZE AND CASTING
        final EditText editText11 = (EditText)findViewById(R.id.editText11);
        final EditText editText12 = (EditText)findViewById(R.id.editText12);
        Button button19 = (Button)findViewById(R.id.button19);
        Button button20 = (Button)findViewById(R.id.button20);
        final ImageView imageView14 = (ImageView)findViewById(R.id.imageView14);
        final ImageView imageView15 = (ImageView)findViewById(R.id.imageView15);
        final ImageView imageView16 = (ImageView)findViewById(R.id.imageView16);
        final ImageView imageView17 = (ImageView)findViewById(R.id.imageView17);
        final ImageView imageView18 = (ImageView)findViewById(R.id.imageView18);

        // MAKE IMAGE VIEW GONE
        imageView14.setVisibility(View.GONE);
        imageView15.setVisibility(View.GONE);
        imageView16.setVisibility(View.GONE);
        imageView17.setVisibility(View.GONE);
        imageView18.setVisibility(View.GONE);

        button19.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TAKING INPUTS
                height = Integer.parseInt(editText11.getText().toString());
                height = height / 100;
                weight = Double.parseDouble(editText12.getText().toString());
                result = (weight /(height * height));

                if(result <= 18.5)
                {
                    imageView14.setVisibility(View.VISIBLE);
                }

                if(result > 18.5 && result <= 24.9)
                {
                    imageView15.setVisibility(View.VISIBLE);
                }

                if(result > 24.9 && result <= 29.9)
                {
                   imageView16.setVisibility(View.VISIBLE);
                }

                if(result > 29.9 && result <= 34.9)
                {
                   imageView17.setVisibility(View.VISIBLE);
                }

                if(result > 34.9)
                {
                   imageView18.setVisibility(View.VISIBLE);
                }
            }
        });

        // CLEAR
        button20.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imageView14.setVisibility(View.GONE);
                imageView15.setVisibility(View.GONE);
                imageView16.setVisibility(View.GONE);
                imageView17.setVisibility(View.GONE);
                imageView18.setVisibility(View.GONE);
                editText11.setText("");
                editText12.setText("");
            }
        });
    }
}







