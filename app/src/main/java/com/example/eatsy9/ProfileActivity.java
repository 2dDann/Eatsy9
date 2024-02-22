package com.example.eatsy9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    private static final int EDIT_PROFILE_REQUEST_CODE = 1;
    private TextView fullNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullNameTextView = findViewById(R.id.fullnametextView);

        ImageView toEditProfileImageView = findViewById(R.id.toeditprofileimageView);
        toEditProfileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to EditProfileActivity
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
            }
        });

        ImageView toFavouriteMealsImageView = findViewById(R.id.tofavouritemealsimageView);
        toFavouriteMealsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate to FavouritesActivity
                Intent intent =  new Intent(ProfileActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });

        ImageView toHelpCenterImageView = findViewById(R.id.tohelpcenterimageView);
        toHelpCenterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate to FavouritesActivity
                Intent intent =  new Intent(ProfileActivity.this, HelpCenterActivity.class);
                startActivity(intent);
            }
        });


    }

    // Handle the result returned from EditProfileActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            // Extract first name and last name from the intent
            String firstName = data.getStringExtra("FIRST_NAME");
            String lastName = data.getStringExtra("LAST_NAME");

            // Update the fullNameTextView with the concatenated first name and last name
            fullNameTextView.setText(firstName + " " + lastName);
        }
    }
}
