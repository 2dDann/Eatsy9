package com.example.eatsy9.model;

public class PackageIngredient {
    private PackageIngredientId id;
    private Mealpackage packageId;
    private Ingredient ingredientId;

    public PackageIngredient() {

    }

    public PackageIngredient(PackageIngredientId id, Mealpackage packageId, Ingredient ingredientId) {
        this.id = id;
        this.packageId = packageId;
        this.ingredientId = ingredientId;
    }
}