package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.IngredientSupplier;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IngredientSupplierApiService {

    @GET("/api/IngredientSuppliers/allIngredientSuppliers")
    Call<List<IngredientSupplier>> findAllSuppliers();

    @GET("/api/IngredientSuppliers/getIngredientSupplierById/{id}")
    Call<IngredientSupplier> findSupplierById(@Path("id") int supplierid);

    @POST("/api/IngredientSuppliers/addIngredientSupplier")
    Call<IngredientSupplier> addIngredientSupplier(@Body IngredientSupplier supplier);

    @PUT("/api/IngredientSuppliers/updateIngredientSupplier")
    Call<IngredientSupplier> updateIngredientSupplier(@Body IngredientSupplier supplier);

    @DELETE("/api/IngredientSuppliers/deleteIngredientSupplierById/{id}")
    Call<Void> deleteIngredientSupplierById(@Path("id") int id);
}
