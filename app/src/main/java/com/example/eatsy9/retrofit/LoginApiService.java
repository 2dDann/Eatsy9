package com.example.eatsy9.retrofit;

import com.example.eatsy9.dto.LoginDto;
import com.example.eatsy9.dto.LoginRegistrationWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiService {

    @POST("/api/login/save")
    Call<String> saveCustomerLogin(@Body LoginRegistrationWrapper reg); //reg?

    @POST("/api/login/login")
    Call<Login> customerLogin(@Body LoginDto loginInfo); //loginInfo? & Login?
}
