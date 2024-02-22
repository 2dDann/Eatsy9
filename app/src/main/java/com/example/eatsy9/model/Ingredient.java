package com.example.eatsy9.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ingredient {
    private Integer id;
    private String ingredientNo;
    private String ingredientName;
    private BigDecimal price;
    private LocalDate expiryDate;
    private Integer expiryDuration;
    private Integer unitInStock;
    private Integer reorderLevel;
    private IngredientSupplier supplier;
    private Set<Mealpackage> mealpackages = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientNo='" + ingredientNo + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", expiryDuration=" + expiryDuration +
                ", unitInStock=" + unitInStock +
                ", reorderLevel=" + reorderLevel +
                '}';
    }
}