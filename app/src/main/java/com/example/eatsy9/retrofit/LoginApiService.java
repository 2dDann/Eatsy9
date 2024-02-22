package com.example.eatsy9.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiService {

    @POST("/api/login/save")
    Call<String> saveCustomerLogin(@Body LoginRegistrationWrapper reg);

    @POST("/api/login/login")
    Call<LoginResponse> customerLogin(@Body LoginDto loginInfo);
}
