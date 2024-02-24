package com.example.eatsy9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eatsy9.adapters.MenuVerAdapter;
import com.example.eatsy9.models.MenuVerModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuActivity extends AppCompatActivity{

    RecyclerView menuVerticalRec;
    List<MenuVerModel> menuVerModelList;
    MenuVerAdapter menuVerAdapter;
    SearchView searchView;

    TextView textView;

    private Button btnAll, btnBreakfast, btnLunch, btnDinner;
    private View selectedOptionIndicator;

    private static final String ALL_MEALS = "All";
    private static final String BREAKFAST = "Breakfast";
    private static final String LUNCH = "Lunch";
    private static final String DINNER = "Dinner";

    private final List<MenuVerModel> savedMealsList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_menu);

            // Initialize views
            menuVerticalRec = findViewById(R.id.menu_ver_rec);
            searchView = findViewById(R.id.search);
            textView = findViewById(R.id.back_all_menu);
            btnAll = findViewById(R.id.btnAll);
            btnBreakfast = findViewById(R.id.btnBreakfast);
            btnLunch = findViewById(R.id.btnLunch);
            btnDinner = findViewById(R.id.btnDinner);
            selectedOptionIndicator = findViewById(R.id.selectedOptionIndicator);


            loadMenuItems();
            setupSearchView();

            // Click listeners for filter buttons
            btnAll.setOnClickListener(v -> filterMenuItems(ALL_MEALS));
            btnBreakfast.setOnClickListener(v -> filterMenuItems(BREAKFAST));
            btnLunch.setOnClickListener(v -> filterMenuItems(LUNCH));
            btnDinner.setOnClickListener(v -> filterMenuItems(DINNER));

            TextView textView = findViewById(R.id.back_all_menu);

            // Handle click event for the All Menu Back TextView
            textView.setOnClickListener(v -> finish());

            // By default, select "All" option in filter menu
            ViewTreeObserver viewTreeObserver = btnAll.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // The listener removed to avoid multiple calls
                    btnAll.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    // Call selectOption with the initialized buttons
                    selectOption(btnAll);
                }
            });



    }
    


    // Method to save a meal to SharedPreferences
    public void saveMealToSharedPreferences(MenuVerModel meal) {
        // Retrieve the existing saved meals set
        SharedPreferences sharedPreferences = getSharedPreferences("SavedMeals", Context.MODE_PRIVATE);
        Set<String> savedMealsSet = sharedPreferences.getStringSet("savedMeals", new HashSet<>());

        // Convert the meal to a string representation
        String mealString = meal.getIv_recipe() + "," + meal.getMealType() + "," + meal.getTv_calorie() + "," + meal.getTv_time() + "," + meal.getTv_meal_title();

        // Add the new meal to the set
        savedMealsSet.add(mealString);

        // Save the updated set back to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("savedMeals", savedMealsSet);
        editor.apply();
    }

    public void removeMealFromSharedPreferences(MenuVerModel meal) {
        // Retrieve the existing saved meals set
        SharedPreferences sharedPreferences = getSharedPreferences("SavedMeals", Context.MODE_PRIVATE);
        Set<String> savedMealsSet = sharedPreferences.getStringSet("savedMeals", new HashSet<>());

        // Convert the meal to a string representation
        String mealString = meal.getIv_recipe() + "," + meal.getMealType() + "," + meal.getTv_calorie() + "," + meal.getTv_time() + "," + meal.getTv_meal_title();

        // Remove the meal from the set
        savedMealsSet.remove(mealString);

        // Save the updated set back to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("savedMeals", savedMealsSet);
        editor.apply();
    }



    // Method to load menu items
    private void loadMenuItems() {

        menuVerModelList = new ArrayList<>();

        // Add menu items to the list
        menuVerModelList.add(new MenuVerModel(R.drawable.b1_yogurt, "Breakfast", "190 - 200 kcal", "10", "Yogurt Parfait"));
        menuVerModelList.add(new MenuVerModel(R.drawable.b2_toast, "Breakfast", "220 - 250 kcal", "5", "Peanut Butter Banana Toast"));
        menuVerModelList.add(new MenuVerModel(R.drawable.b3_eggs, "Breakfast", "147 - 167 kcal", "12", "Scrambled Eggs with Spinach"));
        menuVerModelList.add(new MenuVerModel(R.drawable.b4_burrito, "Breakfast", "380 - 475 kcal", "35", "Breakfast Burrito"));
        menuVerModelList.add(new MenuVerModel(R.drawable.l1_veggie_bowl, "Lunch", "116 kcal", "10", "Cottage Cheese & Veggie Bowl"));
        menuVerModelList.add(new MenuVerModel(R.drawable.l2_lentil_salad, "Lunch", "231 - 241 kcal", "25", "Lentil Salad"));
        menuVerModelList.add(new MenuVerModel(R.drawable.l3_chicken_salad, "Lunch", "205 kcal", "20", "Easy Chicken Salad"));
        menuVerModelList.add(new MenuVerModel(R.drawable.l4_turkey_wrap, "Lunch", "243 - 303 kcal", "15", "Hummus & Turkey Wrap"));
        menuVerModelList.add(new MenuVerModel(R.drawable.d1_broccoli, "Dinner", "251 kcal", "25", "Broccoli & Chickpea Stir-Fry"));
        menuVerModelList.add(new MenuVerModel(R.drawable.d2_grill_chicken, "Dinner", "400 kcal", "30", "Grilled Chicken with Roasted Vegetables"));
        menuVerModelList.add(new MenuVerModel(R.drawable.d3_quinoa, "Dinner", "404 kcal", "30", "Quinoa & Black Bean Bowl"));
        menuVerModelList.add(new MenuVerModel(R.drawable.d4_salmon, "Dinner", "541 kcal", "40", "Salmon with Sweet Potato & Asparagus"));

        // Initialize and set up the adapter
        menuVerAdapter = new MenuVerAdapter(this, menuVerModelList, this);
        menuVerticalRec.setAdapter(menuVerAdapter);
        menuVerticalRec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        menuVerticalRec.setHasFixedSize(true);
        menuVerticalRec.setNestedScrollingEnabled(false);
        menuVerAdapter.setSavedMealsList(savedMealsList);
    }

    // Method to filter menu items based on meal type
    private void filterMenuItems(String mealType) {

        List<MenuVerModel> filteredList = new ArrayList<>();

        if (mealType.equals(ALL_MEALS)) {
            // If "All" is selected, show all menu items
            filteredList.addAll(menuVerModelList);
        } else {
            // Filter menu items based on the selected meal type
            for (MenuVerModel item : menuVerModelList) {
                if (item.getMealType().equalsIgnoreCase(mealType)) {
                    filteredList.add(item);
                }
            }
        }

        // Update adapter with filtered list
        menuVerAdapter.setMenuList(filteredList);
        // Update UI to indicate the selected option
        switch (mealType) {
            case ALL_MEALS:
                selectOption(btnAll);
                break;
            case BREAKFAST:
                selectOption(btnBreakfast);
                break;
            case LUNCH:
                selectOption(btnLunch);
                break;
            case DINNER:
                selectOption(btnDinner);
                break;
        }
    }

    private void selectOption(Button button) {
        // Update button text color
        int yellowColor = ContextCompat.getColor(this, R.color.yellow);
        int blackColor = ContextCompat.getColor(this, android.R.color.black);

        btnAll.setTextColor(button == btnAll ? yellowColor : blackColor);
        btnBreakfast.setTextColor(button == btnBreakfast ? yellowColor : blackColor);
        btnLunch.setTextColor(button == btnLunch ? yellowColor : blackColor);
        btnDinner.setTextColor(button == btnDinner ? yellowColor : blackColor);

        // Update selected option indicator position
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) selectedOptionIndicator.getLayoutParams();
        params.width = button.getWidth();
        params.leftMargin = button.getLeft();
        selectedOptionIndicator.setLayoutParams(params);
    }

    // Method to set up the search view
    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Not used, as we want to filter instantly while typing
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter menu items based on the search query
                filterMenuItemsBySearch(newText);
                return true;
            }
        });
    }

    // Method to filter menu items based on search query
    private void filterMenuItemsBySearch(String query) {
        List<MenuVerModel> filteredList = new ArrayList<>();
        for (MenuVerModel item : menuVerModelList) {
            if (item.getTv_meal_title().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        // Update adapter with filtered list
        menuVerAdapter.setMenuList(filteredList);
    }

    }


