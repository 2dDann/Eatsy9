package com.example.eatsy9.dto;

import com.example.eatsy9.model.Contact;
import com.example.eatsy9.model.Customer;
import com.example.eatsy9.model.Login;

public class LoginRegistrationWrapper {
    private Customer cust;
    private Contact cont;
    private Login login;

    public LoginRegistrationWrapper(Customer cust, Contact cont, Login login) {
        this.cust = cust;
        this.cont = cont;
        this.login = login;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public Contact getCont() {
        return cont;
    }

    public void setCont(Contact cont) {
        this.cont = cont;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
