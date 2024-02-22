package com.example.eatsy9.model;

import java.time.LocalDate;

public class CustomerPackage {
    private CustomerPackageId id;
    private Customer customerId;
    private Mealpackage packageId;
    private LocalDate date;
    public CustomerPackage() {

    }

    public CustomerPackage(CustomerPackageId id, Customer customerId, Mealpackage packageId) {
        this.id = id;
        this.customerId = customerId;
        this.packageId = packageId;
    }
}