package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderApiService {

    @GET("/api/orders/allorders")
    Call<List<Order>> findAllOrders();

    @GET("/api/orders/getOrderById/{id}")
    Call<Order> getOrderById(@Path("id") int orderid);

    @POST("/api/orders/addOrder")
    Call<Order> addOrder(@Body Order order);

    @PUT("/api/orders/updateOrder")
    Call<Order> updateOrder(@Body Order order);

    @DELETE("/api/orders/deleteOrderById/{id}")
    Call<Void> deleteOrderById(@Path("id") int id);
}
