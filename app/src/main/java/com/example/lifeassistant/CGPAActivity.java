package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CGPAActivity extends AppCompatActivity
{
    // GLOBAL VARIABLES
    int numberOfLesson, grandgrade, grandcredit;
    int counter = 0;
    int cnt = 0;
    int counter2 = 0;
    int counterOFF = 0;
    EditText ed1, ed2;
    EditText array[] = new EditText[14];
    double arrayValue[] = new double[14];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        // VARIABLE INITIALIZE AND CASTING
        Button button22 = (Button)findViewById(R.id.button22);
        Button button23 = (Button)findViewById(R.id.button23);
        final EditText editText5 = (EditText)findViewById(R.id.editText5);
        final EditText editText6 = (EditText)findViewById(R.id.editText6);
        final EditText editText7 = (EditText)findViewById(R.id.editText7);
        final TextView textView11 = (TextView)findViewById(R.id.textView11);


        // CREATE LIST
        button22.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numberOfLesson = Integer.parseInt(editText5.getText().toString());
                grandgrade = Integer.parseInt(editText6.getText().toString());
                grandcredit = Integer.parseInt(editText7.getText().toString());

                if(numberOfLesson >= 8)
                {
                    Toast.makeText(CGPAActivity.this, "Maximum allowed lesson number is 7", Toast.LENGTH_SHORT).show();
                    numberOfLesson = 0;
                }


                for(; cnt < numberOfLesson; cnt++)
                {
                    // LAYOUT INITIALIZING AND CASTING
                    LinearLayout linearLayout4 = (LinearLayout)findViewById(R.id.linearLayout4);
                    LinearLayout linearLayout5 = (LinearLayout)findViewById(R.id.linearLayout5);

                    // CREATING NEW EDITTEXT
                    ed1 = new EditText(CGPAActivity.this);
                    ed2 = new EditText(CGPAActivity.this);

                    // RECORDING EDITTEXTs
                    array[counterOFF] = ed1;
                    array[counterOFF + 1] = ed2;
                    counterOFF = counterOFF + 2;

                    // CREATE VIEW ON LAYOUTS
                    linearLayout4.addView(ed1);
                    linearLayout5.addView(ed2);
                }
            }
        });

        // CALCULATE BUTTON ONCLICK
        button23.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                double number1 = 0, number2 = 0, temp = 0, result = 0, sum = 0;
                double credit = 0;

                // GETTING INPUT
                for(; counter < numberOfLesson*2; counter++)
                {
                    arrayValue[counter] = Integer.parseInt(array[counter].getText().toString());
                }

                // CALCULATING ALGORITHM
                for(; counter2 < numberOfLesson*2; counter2++)
                {
                    temp = arrayValue[counter2] * arrayValue[counter2 + 1];
                    sum = sum + temp;
                    credit = credit + arrayValue[counter2 + 1];
                    counter2++;
                }
                result = (sum + grandgrade) / (grandcredit + credit);

                textView11.setText("cGPA: " + String.valueOf(result));
            }
        });
    }
}
