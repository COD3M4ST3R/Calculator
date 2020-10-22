package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // VARIABLE INITIALIZING
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // VARIABLE CASTING
        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayList<String> arrayList_Calculator = new ArrayList<>();

        // ADS
        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        adView.loadAd(adRequest);


        arrayList_Calculator.add("MATH CALCULATOR");
        arrayList_Calculator.add("GRADE CALCULATOR");
        arrayList_Calculator.add("MORTGAGE CALCULATOR");
        arrayList_Calculator.add("LOAN CALCULATOR");
        arrayList_Calculator.add("BODY MASS INDEX CALCULATOR");
        arrayList_Calculator.add("WATER CALCULATOR & TRACKER");


        ArrayAdapter arrayAdapter_Calculator = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList_Calculator);
        listView.setAdapter(arrayAdapter_Calculator);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // MATH CALCULATOR
                if(position == 0)
                {
                    openMathCalculator();
                }

                // GRADE CALCULATOR
                if(position == 1)
                {
                    openGradeCalculator();
                }

                // MORTGAGE CALCULATOR
                if(position == 2)
                {
                    openMortageCalculator();
                }

                // LOAN CALCULATOR
                if(position == 3)
                {
                    openLoanCalculator();
                }

                // BODY CALCULATOR
                if(position == 4)
                {
                    openBodyCalculator();
                }

                // WATER CALCULATOR
                if(position == 5)
                {
                    openWater();
                }
            }
        });

    }

    // INTENTS OF CALCULATORS

    // OPENS MATH CALCULATOR
    public void openMathCalculator()
    {
        Intent intent_MathCalculator = new Intent(this, MathActivity.class);
        startActivity(intent_MathCalculator);
    }

    // OPENS GRADE CALCULATOR
    public void openGradeCalculator()
    {
        Intent intent_GradeCalculator = new Intent(this, GradeActivity.class);
        startActivity(intent_GradeCalculator);
    }

    // OPENS MORTAGAE CALCULATOR
    public void openMortageCalculator()
    {
        Intent intent_MortageCalculator = new Intent(this, MortageActivity.class);
        startActivity(intent_MortageCalculator);
    }

    // OPENS LOAN CALCULATOR
    public void openLoanCalculator()
    {
        Intent intent_LoanCalculator = new Intent(this, LoanActivity.class);
        startActivity(intent_LoanCalculator);
    }

    // OPENS BODY CALCUlATOR
    public void openBodyCalculator()
    {
        Intent intent_BodyCalculator = new Intent(this, BodyActivity.class);
        startActivity(intent_BodyCalculator);
    }

    // OPENS WATER CALCULATOR
    public void openWater()
    {
        Intent intent_Water = new Intent(this,WaterActivity.class);
        startActivity(intent_Water);
    }
}


