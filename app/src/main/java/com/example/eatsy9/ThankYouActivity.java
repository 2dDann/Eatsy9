package com.example.eatsy9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        // Find the ImageView
        ImageView thankyouimageView = findViewById(R.id.thankyouimageView);

        // Set OnClickListener to the ImageView
        thankyouimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the NotificationActivity when the ImageView is clicked
                Intent intent = new Intent(ThankYouActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }
}
