package com.example.eatsy9;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HelpCenterActivity extends AppCompatActivity {

    private EditText searchEditText;
    private RecyclerView searchResultsRecyclerView;
    private HelpCenterAdapter helpCenterAdapter;
    private List<HelpItem> allHelpItems; // List of all help items
    private List<HelpItem> filteredHelpItems; // List of help items after filtering

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        ImageView FavouritesNavImageView = findViewById(R.id.helpcenternavimageView);
        FavouritesNavImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ProfileActivity
                finish();
            }
        });

        searchEditText = findViewById(R.id.searchEditText);
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView);
        allHelpItems = getAllHelpItems(); // Initialize the list of help items
        filteredHelpItems = new ArrayList<>();

        helpCenterAdapter = new HelpCenterAdapter(filteredHelpItems);
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchResultsRecyclerView.setAdapter(helpCenterAdapter);

        // Implement text change listener for search EditText
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterHelpItems(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Click listener for imageView5
        findViewById(R.id.help_deliveries_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHelpItems("delivery");
            }
        });

        // Click listener for help_account_imageView
        findViewById(R.id.help_account_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHelpItems("account");
            }
        });

        // Click listener for imageView10
        findViewById(R.id.help_ingredients_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHelpItems("ingredients");
            }
        });

        // Click listener for imageView10
        findViewById(R.id.help_payments_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHelpItems("payment");
            }
        });

        // Click listener for imageView10
        findViewById(R.id.help_about_eatsy_imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterHelpItems("eatsy");
            }
        });

        // Add click listeners for other ImageViews as needed
    }

    // Method to filter help items based on user input
    private void filterHelpItems(String query) {
        filteredHelpItems.clear();
        for (HelpItem helpItem : allHelpItems) {
            if (helpItem.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredHelpItems.add(helpItem);
            }
        }
        helpCenterAdapter.notifyDataSetChanged();
    }

    // Dummy method to get all help items (you should replace this with your actual data source)
    private List<HelpItem> getAllHelpItems() {
        List<HelpItem> helpItems = new ArrayList<>();
        // Add your help items to the list
        helpItems.add(new HelpItem("Can I skip a delivery?", "You can skip a delivery by..."));
        helpItems.add(new HelpItem("Can I change my delivery window?", "Yes, you can change your delivery window..."));

        helpItems.add(new HelpItem("Can I add meal preferences to my account?", "You can add meal preferences to your account by..."));
        helpItems.add(new HelpItem("How does Eatsy use my account data?", "Eatsy makes use of account data in..."));
        helpItems.add(new HelpItem("How do i login to my Eatsy account?", "To log into your Eatsy account..."));

        helpItems.add(new HelpItem("I have a missing ingredients", "In the event of missing ingredients in Meal kits..."));
        helpItems.add(new HelpItem("Dissatisfied with quality of ingredients", "In the event of dissatisfaction with ingredients..."));
        helpItems.add(new HelpItem("Are the ingredients organic?", "You can skip a delivery by..."));

        helpItems.add(new HelpItem("How do I update my payment details?", "You can skip a delivery by..."));
        helpItems.add(new HelpItem("What payment methods do you accept?", "You can skip a delivery by..."));

        helpItems.add(new HelpItem("What is Eatsy?", "Eatsy is a meal planning application..."));


        // Add more items as needed
        return helpItems;
    }
}


