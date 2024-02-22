package com.example.eatsy9.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Login {
    private Integer id;
    private Customer customer;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}