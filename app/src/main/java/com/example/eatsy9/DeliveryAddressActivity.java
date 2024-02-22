package com.example.eatsy9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class DeliveryAddressActivity extends AppCompatActivity {


    private Spinner stateSpinner;
    private EditText streetAddressEditText, cityEditText, zipCodeEditText;

    private Button buttonSaveContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);

        // Initialize views

        stateSpinner = findViewById(R.id.spinner_state);

        streetAddressEditText = findViewById(R.id.edit_text_street_address);
        cityEditText = findViewById(R.id.edit_text_city);
        zipCodeEditText = findViewById(R.id.edit_text_zip_code);

        buttonSaveContinue =  findViewById(R.id.save_continuebutton);

        // Set up the spinner for the State field
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.state_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(adapter);

        // Set onClickListener for the Save and Continue button
        buttonSaveContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to validate inputs and proceed



                saveandContinue();

            }
        });

    }

    private void saveandContinue(){

        //Retrieve inputs
        String streetAddress = streetAddressEditText.getText().toString().trim();
        String city = cityEditText.getText().toString().trim();
        String zipCode = zipCodeEditText.getText().toString().trim();
        String state = stateSpinner.getSelectedItem().toString();

        //Perform Validations

        if (streetAddress.isEmpty()) {
            streetAddressEditText.setError("Street Address is required");
            streetAddressEditText.requestFocus();
            return;
        }

        if (city.isEmpty()) {
            cityEditText.setError("City is required");
            cityEditText.requestFocus();
            return;
        }

        if (zipCode.isEmpty()) {
            zipCodeEditText.setError("Zip Code is required");
            zipCodeEditText.requestFocus();
            return;
        } else if (zipCode.length() != 5) {
            zipCodeEditText.setError("Zip Code must be exactly 5 characters");
            zipCodeEditText.requestFocus();
            return;
        }

        // Check if any of the required fields are empty
        if (TextUtils.isEmpty(streetAddress) ||
                TextUtils.isEmpty(city) || TextUtils.isEmpty(zipCode) ||
                state.equals("Select State")) {
            // Show a toast message indicating that all fields are required
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        //Add Logic to save delivery details here






        //Navigate to CheckoutActivity
        Intent intent = new Intent(DeliveryAddressActivity.this, CheckoutActivity.class);
        intent.putExtra("streetAddress", streetAddress);
        intent.putExtra("city", city);
        intent.putExtra("zipCode", zipCode);
        intent.putExtra("state", state);
        startActivity(intent);




    }
}