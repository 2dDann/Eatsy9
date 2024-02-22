package com.example.eatsy9.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Order {
    private Integer id;
    private String orderNo;
    private LocalDate orderDate;
    private String orderStatus;
    private DeliveryPartner partner;
    private Payment payment;
    private Customer customer;
    private Set<Mealpackage> mealpackages = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}