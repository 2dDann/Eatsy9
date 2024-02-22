package com.example.eatsy9.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Payment {
    private Integer id;
    private String paymentNo;
    private String paymentMode;
    private BigDecimal amount;
    private Customer customer;
    private Set<Order> orders = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentNo='" + paymentNo + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", amount=" + amount +
                '}';
    }
}