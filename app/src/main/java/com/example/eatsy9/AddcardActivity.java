package com.example.eatsy9;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddcardActivity extends AppCompatActivity {

    private EditText editTextCardNumber;
    private EditText editTextExpiryDate;
    private EditText editTextCVV;
    private Button addCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpiryDate = findViewById(R.id.editTextExpiryDate);
        editTextCVV = findViewById(R.id.editTextCVV);
        addCardButton = findViewById(R.id.addnumberButton);


        // Add TextWatcher to format card number input
        editTextCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No implementation needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No implementation needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.isEmpty() && (input.length() % 5) == 0 && input.charAt(input.length() - 1) != ' ') {
                    // Insert a space after every 4 characters if the last character is not already a space
                    StringBuilder formattedText = new StringBuilder(input.replaceAll("\\s", ""));
                    for (int i = 4; i < formattedText.length(); i += 5) {
                        formattedText.insert(i, " ");
                    }
                    editTextCardNumber.removeTextChangedListener(this); // Remove listener to avoid infinite loop
                    editTextCardNumber.setText(formattedText.toString());
                    editTextCardNumber.setSelection(formattedText.length());
                    editTextCardNumber.addTextChangedListener(this); // Add listener back
                }
            }
        });





        // Add TextWatcher to format expiry date input
        editTextExpiryDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No implementation needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No implementation needed
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (input.length() == 2 && !input.contains("/")) {
                    editTextExpiryDate.setText(input + "/");
                    editTextExpiryDate.setSelection(editTextExpiryDate.getText().length());
                }
            }
        });



        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String cardNumber = editTextCardNumber.getText().toString().trim();
                String expiryDate = editTextExpiryDate.getText().toString().trim();
                String cvv = editTextCVV.getText().toString().trim();

                // Check if inputs are valid
                if (TextUtils.isEmpty(cardNumber)) {
                    editTextCardNumber.setError("Card Number Required");
                } else if (TextUtils.isEmpty(expiryDate)) {
                    editTextExpiryDate.setError("Expiry Date Required");
                } else if (TextUtils.isEmpty(cvv)) {
                    editTextCVV.setError("CVV Required");
                } else if (isValidInput(cardNumber, expiryDate, cvv)) {
                    // Add card logic goes here

                    // Pass the last 4 digits to CheckoutActivity
                    Intent intent = new Intent(AddcardActivity.this, CheckoutActivity.class);
                    intent.putExtra("last4digits", cardNumber.substring(cardNumber.length() - 4));
                    startActivity(intent);


                    Toast.makeText(AddcardActivity.this, "Card added successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddcardActivity.this, "Please enter valid card details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Method to validate user input
    private boolean isValidInput(String cardNumber, String expiryDate, String cvv) {
        // Check if any field is empty
        if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
            return false;
        }

        // Card number validation (example: check for 16 digits)
        if (cardNumber.replaceAll(" ", "").length() != 16) {
            return false;
        }

        // Expiry date validation (example: check MM/YY format and future date)
        if (!expiryDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }

        // CVV validation (example: check for 3 digits)
        if (cvv.length() != 3) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

}
