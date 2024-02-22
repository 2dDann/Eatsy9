package com.example.eatsy9.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class IngredientSupplier {
    private Integer id;
    private String firstName;
    private String lastName;
    private String supplierNo;
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "IngredientSupplier{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", supplierNo='" + supplierNo + '\'' +
                '}';
    }
}