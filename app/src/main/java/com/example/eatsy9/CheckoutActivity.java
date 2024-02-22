package com.example.eatsy9;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class CheckoutActivity extends AppCompatActivity {

    private TextView addPaymentMethodTextView;
    private TextView addDeliveryAddressTextView;
    private TextView changepaymentTextView1;

    private TextView changepaymentTextView2;

    private TextView deliveryDateTextView;
    private Calendar calendar;

    private static final String CHANNEL_ID = "notification_channel_id";
    private static final String CHANNEL_NAME = "Notification Channel";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Get the last 4 digits of the card number from AddcardActivity
        String last4Digits = getIntent().getStringExtra("last4digits");

        String streetAddress = getIntent().getStringExtra("streetAddress");
        String city = getIntent().getStringExtra("city");
        String zipCode = getIntent().getStringExtra("zipCode");
        String state = getIntent().getStringExtra("state");

        // Assuming you have TextView fields to display the address details
        TextView addressTextView = findViewById(R.id.adddeliveryaddresstextView);
        addressTextView.setText("Street Address: " + streetAddress + "\n" +
                "City: " + city + "\n" +
                "Zip Code: " + zipCode + "\n" +
                "State: " + state);

        // Find the TextView and set the last 4 digits
        TextView paymentMethodTextView = findViewById(R.id.addpaymentmethodtextView);
        if (last4Digits != null) {
            paymentMethodTextView.setText("**** **** **** " + last4Digits);
        }

        // Find the CHANGE button for Payment Method
        changepaymentTextView1 = findViewById(R.id.changepaymentmethodtextView1);

        // Set OnClickListener to the CHANGE button for Payment Method
        changepaymentTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AddcardActivity when the CHANGE button is clicked
                Intent intent = new Intent(CheckoutActivity.this, AddcardActivity.class);
                startActivity(intent);
            }
        });

        // Find the CHANGE button for Delivery Address
        changepaymentTextView2 = findViewById(R.id.changepaymentmethodtextView2);

        // Set OnClickListener to the CHANGE button for Delivery Address
        changepaymentTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open DeliveryAddressActivity when the CHANGE button is clicked
                Intent intent = new Intent(CheckoutActivity.this, DeliveryAddressActivity.class);
                startActivity(intent);
            }
        });



        addPaymentMethodTextView = findViewById(R.id.addpaymentmethodtextView);

        addPaymentMethodTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open PaymentMethodActivity when addPaymentMethodTextView is clicked
                Intent intent = new Intent(CheckoutActivity.this, PaymentMethodActivity.class);
                startActivity(intent);
            }
        });


        addDeliveryAddressTextView = findViewById(R.id.adddeliveryaddresstextView);

        addDeliveryAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open DeliveryAddressActivity when addDeliveryAddressTextView is clicked
                Intent intent = new Intent(CheckoutActivity.this, DeliveryAddressActivity.class);
                startActivity(intent);
            }
        });

        deliveryDateTextView = findViewById(R.id.deliveryDateTextView);
        calendar = Calendar.getInstance();

        // Set OnClickListener to open the DatePickerDialog
        deliveryDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Find the "Place Order" button
        Button placeOrderButton = findViewById(R.id.placeorderbutton);

        // Set OnClickListener to the "Place Order" button
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ThankYouActivity when the button is clicked
                Intent intent = new Intent(CheckoutActivity.this, ThankYouActivity.class);
                startActivity(intent);
            }
        });

        createNotificationChannel();





    }
    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        updateDeliveryDateTextView();
                    }
                }, year, month, dayOfMonth);

        // Customize the DatePickerDialog to allow only Sundays
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.getDatePicker().setCalendarViewShown(false);
        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar selected = Calendar.getInstance();
                selected.set(year, monthOfYear, dayOfMonth);
                if (selected.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    // Prevent the dialog from closing
                    view.init(year, monthOfYear, dayOfMonth, this);
                    // Display a Toast message indicating delivery is only on Sundays
                    Toast.makeText(getApplicationContext(), "We only deliver on Sundays", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the delivery date TextView if the selected date is Sunday
                    calendar.set(year, monthOfYear, dayOfMonth);
                    updateDeliveryDateTextView();
                }
            }
        });

// Set an OnClickListener for the "OK" button in the DatePickerDialog
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Check if the selected date is a Sunday
                if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    // Display a Toast message indicating delivery is only on Sundays
                    Toast.makeText(getApplicationContext(), "We only deliver on Sundays", Toast.LENGTH_SHORT).show();
                    // Prevent the dialog from closing
                    datePickerDialog.show();
                } else {
                    // Update the delivery date TextView if the selected date is Sunday
                    updateDeliveryDateTextView();
                }
            }
        });




        datePickerDialog.show();
    }


    private void updateDeliveryDateTextView() {
        // Format the date and update the TextView
        String deliveryDate = android.text.format.DateFormat.format("EEEE, MMMM d, yyyy", calendar).toString();
        deliveryDateTextView.setText(deliveryDate);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = CHANNEL_NAME;
            String description = "Notification Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}
