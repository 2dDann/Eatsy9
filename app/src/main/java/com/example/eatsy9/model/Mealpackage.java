package com.example.eatsy9.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Mealpackage {
    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    private String packageName;
    private String packageNo;
    private String description;
    private Set<Customer> customers = new LinkedHashSet<>();
    private Set<Order> orders = new LinkedHashSet<>();
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Mealpackage{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", packageName='" + packageName + '\'' +
                ", packageNo='" + packageNo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

/*

    @OneToMany(mappedBy = "mealpackage")
    private Set<CustomerPackage> customerPackages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mealpackage")
    private Set<OrderPackage> orderPackages = new LinkedHashSet<>();


    @ManyToMany(mappedBy = "mealpackage")
    private Set<Ingredient> ingredients = new LinkedHashSet<>();
*/

}