package com.example.lifeassistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BroadcastReceiver1 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "101")
                .setSmallIcon(R.drawable.logologo)
                .setContentTitle("Water Tracker")
                .setContentText("Let's Drink Water!")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(101, builder.build());
    }
}
