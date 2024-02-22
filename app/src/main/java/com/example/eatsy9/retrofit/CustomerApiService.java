package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Contact;
import com.example.eatsy9.model.Customer;
import com.example.eatsy9.model.Order;
import com.example.eatsy9.model.Payment;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CustomerApiService {

    @GET("/api/customers/allcustomers")
    Call<List<Customer>> findAllCustomers();

    @GET("/api/customers/getCustomerById/{id}")
    Call<Customer> findCustomerById(@Path("id") int cusid);

    @GET("/api/customers/getCustomerByCustomerNo/{customerNo}")
    Call<Optional<Customer>> findCustomerByCustomerNo(@Path("customerNo") String customerNo);

    @POST("/api/customers/addCustomer")
    Call<Customer> findCustomerByCustomerNo(@Body Customer customer); //double check

    @PUT("/api/customers/updateCustomer")
    Call<Customer> updateCustomer(@Body Customer customer);

    @DELETE("/api/customers/deleteCustomerById/{id}")
    Call<Void> deleteCustomer(@Path("id") int id);

    @DELETE("/api/customers/removeCustomerByNo/{customerNo}")
    Call<Optional<String>> removeCustomer(@Path("customerNo") String customerNo);

    @GET("/api/customers/getAllContactsByCustomer/{customerno}")
    Call<Set<Contact>> findAllContactsByCustomer(@Path("customerno") String customerno);

    @GET("/api/customers/getAllOrdersByCustomer/{customerno}")
    Call<Set<Order>> findAllOrdersByCustomer(@Path("customerno") String customerno);

    @GET("/api/customers/getAllPaymentssByCustomer/{customerno}")
    Call<Set<Payment>> findAllPaymentsByCustomer(@Path("customerno") String customerno);
}
