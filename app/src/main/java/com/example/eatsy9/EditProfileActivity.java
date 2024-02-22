package com.example.eatsy9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        final EditText firstNameEditText = findViewById(R.id.edit_text_first_name);
        final EditText lastNameEditText = findViewById(R.id.edit_text_last_name);
        Button updateProfileButton = findViewById(R.id.update_profile_button);

        updateProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the first name and last name inputs
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();

                // Create an intent to pass data back to ProfileActivity
                Intent intent = new Intent();
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        ImageView editProfileNavImageView = findViewById(R.id.editprofilenavimageView);
        editProfileNavImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ProfileActivity
                finish();
            }
        });
    }
}
