package com.example.eatsy9.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String customerNo;
    private String streetAddress;
    private String city;
    private String state;
    private Integer zipCode;
    private Set<Contact> contacts = new LinkedHashSet<>();
    private Set<Mealpackage> mealpackages = new LinkedHashSet<>();
    private Login login;
    private Set<Order> orders = new LinkedHashSet<>();
    private Set<Payment> payments = new LinkedHashSet<>();
    private Questionnaire questionnaire;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public Customer(Integer id, String firstName, String lastName, String customerNo, String streetAddress, String city, String state, Integer zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNo = customerNo;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}