package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

public class LoanActivity extends AppCompatActivity
{
    RadioButton radioButton;
    RadioGroup radioGroup;
    int totalAmount, term;
    double totalPayment, interest, payment, interestRate;
    String daily = "Daily Payment: ";
    String montly = "Montly Payment: ";
    String yearly = "Yearly Payment: ";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        // INITIALIZE AND CASTING
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton radio1 = (RadioButton)findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton)findViewById(R.id.radio2);
        final RadioButton radio3 = (RadioButton)findViewById(R.id.radio3);
        Button button18 = (Button)findViewById(R.id.button18);
        Button button26 = (Button)findViewById(R.id.button26);
        final TextView textView20 = (TextView)findViewById(R.id.textView20);
        final TextView textView21 = (TextView)findViewById(R.id.textView21);
        final TextView textView22 = (TextView)findViewById(R.id.textView22);
        final TextView textView23 = (TextView)findViewById(R.id.textView23);
        final TextView textView26 = (TextView)findViewById(R.id.textView26);
        final TextView textView27 = (TextView)findViewById(R.id.textView27);
        final EditText editText8 = (EditText)findViewById(R.id.editText8);
        final EditText editText9 = (EditText)findViewById(R.id.editText9);
        final EditText editText10 = (EditText)findViewById(R.id.editText10);


        // ADS
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);


        // CALCULATE BUTTON CLICKED
        button18.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                Toast.makeText(LoanActivity.this, "Choosed Pay Back Period: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                totalAmount = Integer.parseInt(editText8.getText().toString());
                interestRate = Integer.parseInt(editText9.getText().toString());
                term = Integer.parseInt(editText10.getText().toString());

                if(radio1.isChecked())
                {
                    interest = (totalAmount * (interestRate / 100) * term);
                    totalPayment = totalAmount + interest;
                    payment = totalPayment / (term * 12 * 30);

                    textView20.setText(String.valueOf(daily));
                    textView26.setText("Total Payment: ");
                    textView27.setText(String.valueOf(totalPayment));
                    textView23.setText(String.valueOf(payment));
                    textView21.setText("Total Interest:");
                    textView22.setText(String.valueOf(interest));
                }

                else if(radio2.isChecked())
                {
                    interest = (totalAmount * (interestRate / 100) * term);
                    totalPayment = totalAmount + interest;
                    payment = totalPayment / (term * 12);

                    textView20.setText(String.valueOf(montly));
                    textView26.setText("Total Payment: ");
                    textView27.setText(String.valueOf(totalPayment));
                    textView23.setText(String.valueOf(payment));
                    textView21.setText("Total Interest:");
                    textView22.setText(String.valueOf(interest));
                }

                else if(radio3.isChecked())
                {
                    interest = (totalAmount * (interestRate / 100) * term);
                    totalPayment = totalAmount + interest;
                    payment = totalPayment / (term);

                    textView20.setText(String.valueOf(yearly));
                    textView26.setText("Total Payment: ");
                    textView27.setText(String.valueOf(totalPayment));
                    textView23.setText(String.valueOf(payment));
                    textView21.setText("Total Interest:");
                    textView22.setText(String.valueOf(interest));
                }
            }
        });

        button26.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                radio1.setChecked(false);
                radio2.setChecked(false);
                radio3.setChecked(false);
                textView20.setText("");
                textView21.setText("");
                textView22.setText("");
                textView23.setText("");
                textView26.setText("");
                textView27.setText("");
                editText8.setText("");
                editText9.setText("");
                editText10.setText("");
            }
        });
    }
}

