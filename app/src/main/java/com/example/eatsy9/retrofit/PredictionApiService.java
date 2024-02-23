package com.example.eatsy9.retrofit;

import com.example.eatsy9.dto.PredictionDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface PredictionApiService {

    @GET("/api/prediction/predict")
    Call<String> predictMeal(@Body PredictionDto meal); //meal?
}
