package com.example.eatsy9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethodActivity extends AppCompatActivity {

    private ImageView cardsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        cardsImageView = findViewById(R.id.cardsimageView);

        cardsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open AddcardActivity when cardsImageView is clicked
                Intent intent = new Intent(PaymentMethodActivity.this, AddcardActivity.class);
                startActivity(intent);
            }
        });
    }
}
