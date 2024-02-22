package com.example.eatsy9;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationActivity extends AppCompatActivity {

    private ImageView notificationImageView;

    private ImageView notifsimageView;



    private static final int DELIVERED_IMAGE_ID = 1;
    private static final int EXPIRY_IMAGE_ID = 2;
    private static final String CHANNEL_ID = "notification_channel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Find the ImageView
        notificationImageView = findViewById(R.id.notificationImageView);

        // Start the timer for image changes
        startImageChangeTimer();

        // Find the ImageView
        notifsimageView = findViewById(R.id.notifsimageView);
        // Set OnClickListener for the ImageView
        notifsimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start ProfileActivity when ImageView is clicked
                Intent intent = new Intent(NotificationActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }

    private void startImageChangeTimer() {
        // Change image to delivered_image after 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notificationImageView.setImageResource(R.drawable.delivered_image);
                showNotification("Package Delivered", "Your package has been delivered!", DELIVERED_IMAGE_ID);
                // Start the timer for next image change
                startExpiryImageTimer();
            }
        }, 10000); // 10 seconds
    }

    private void startExpiryImageTimer() {
        // Change image to expiry_image after another 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notificationImageView.setImageResource(R.drawable.expiry_image);
                showNotification("Package Expiry", "Your package is expiring soon!", EXPIRY_IMAGE_ID);
                // You may perform further actions or close the activity after displaying the last image
            }
        }, 10000); // 10 seconds after the delivery image
    }

    private void showNotification(String title, String message, int notificationId) {
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(notificationId, builder.build());
    }
}
