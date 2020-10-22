package com.example.lifeassistant;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class WaterActivity extends AppCompatActivity
{
    // VARIABLES
    int weight;
    int sleepTime;
    double waterUsage; //  ITS ON LITER

    // XML VARIABLES
    EditText editText16;
    EditText editText17;
    TextView textView41, textView42;
    Button button27, button28, button29, button32;

    // NOTIFICATION ELEMENTS
    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        // CREATE NOTIFICATION CHANNEL
        createChannel1();

        // INITIALIZE AND CASTING
        editText16 = findViewById(R.id.editText16);
        editText17 = findViewById(R.id.editText17);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button32 = findViewById(R.id.button32);
        textView41 = findViewById(R.id.textView41);
        textView42 = findViewById(R.id.textView42);

        // CALCULATE BUTTON ONCLICK
        button27.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                weight = Integer.parseInt(editText16.getText().toString());
                sleepTime = Integer.parseInt(editText17.getText().toString());
                waterUsage = findWaterUsage();
                textView41.setText("Daily Water Requirement is: " + waterUsage + " lt");
            }
        });

        // RESET BUTTON ONCLICK
        button28.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editText16.setText("");
                editText17.setText("");
                textView41.setText("");
            }
        });

        // NOTIFICATION SET BUTTON
        button29.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(WaterActivity.this, "Notifications Set", Toast.LENGTH_SHORT).show();

                alarmManager = (AlarmManager)getSystemService(WaterActivity.ALARM_SERVICE);
                Intent intent = new Intent(WaterActivity.this, BroadcastReceiver1.class);
                pendingIntent = PendingIntent.getBroadcast(WaterActivity.this, 101, intent, 0);

                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                        AlarmManager.INTERVAL_HOUR, pendingIntent);
            }
        });
    }


    public void createChannel1()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "channel1";
            String description = "channel1 description";

            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel1 = new NotificationChannel("101", name,importance);
            channel1.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
        }
    }


    public double findWaterUsage()
    {
        if(weight > 36 && weight <= 44.9)
        {
            return 1.2;
        }

        else if(weight > 45 && weight <= 53.9)
        {
            return 1.5;
        }

        else if(weight > 54 && weight <= 63.9)
        {
            return 1.8;
        }

        else if(weight > 64 && weight <= 72.9)
        {
            return 2.1;
        }

        else if(weight > 73 && weight <= 81.9)
        {
            return 2.4;
        }

        else if(weight > 82 && weight <= 90.9)
        {
            return 2.7;
        }

        else if(weight > 91 && weight <= 99.9)
        {
            return 3.0;
        }

        else if(weight > 100 && weight <= 108.9)
        {
            return  3.3;
        }

        else if(weight > 109 && weight <= 117.9)
        {
            return 3.6;
        }

        else if(weight > 118 && weight <= 126.9)
        {
            return 3.9;
        }

        else
        {
            return 4.0;
        }
    }
}
