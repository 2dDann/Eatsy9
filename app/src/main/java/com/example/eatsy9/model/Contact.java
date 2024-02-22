package com.example.eatsy9.model;

public class Contact {
    private Integer id;
    private String email;
    private String phoneNo;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public Contact(Integer id, String email, String phoneNo) {
        this.id = id;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}