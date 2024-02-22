package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Ingredient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IngredientApiService {

    @GET("/api/ingredients/allIngredients")
    Call<List<Ingredient>> findAllIngredients();

    @GET("/api/ingredients/getIngredientById/{id}")
    Call<Ingredient> getIngredientById(@Path("id") int ingredientid);

    @POST("/api/ingredients/addIngredient")
    Call<Ingredient> addIngredient(@Body Ingredient ingredient);

    @PUT("/api/ingredients/updateIngredient")
    Call<Ingredient> updateIngredient(@Body Ingredient ingredient);

    @DELETE("/api/ingredients/deleteIngredientById/{id}")
    Call<Void> deleteIngredientById(@Path("id") int id);
}
