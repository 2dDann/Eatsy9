package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Contact;
import com.example.eatsy9.model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ContactApiService {

    @GET("/api/contact/allContacts")
    Call<List<Contact>> findAllContacts();

    @POST("/api/contact/addContact/{customerno}")
    Call<Contact> addContact(@Body Contact c, @Path("customerno") String customerno);

    @GET("/api/contact/findCustomerByEmailContact/{email}")
    Call<Customer> findCustomerByEmailContact(@Path("email") String email);
}
