package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Mealpackage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MealPackageApiService {

    @GET("/api/mealpackages/allmealpackages")
    Call<List<Mealpackage>> findAllMealpackages();

    @GET("/api/mealpackages/getMealpackageById/{id}")
    Call<Mealpackage> getMealpackageById(@Path("id") int mealpackageid);

    @POST("/api/mealpackages/addMealpackage")
    Call<Mealpackage> addMealpackage(@Body Mealpackage mealpackage);

    @PUT("/api/mealpackages/updateMealpackage")
    Call<Mealpackage> updateMealpackage(@Body Mealpackage mealpackage);

    @DELETE("/api/mealpackages/deleteMealpackageById/{id}")
    Call<Void> deleteMealpackageById(@Path("id") int id);
}
