package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.DeliveryPartner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DeliveryPartnerApiService {

    @GET("/api/DeliveryPartners/allDeliveryPartners")
    Call<List<DeliveryPartner>> findAllPartners();

    @GET("/api/DeliveryPartners/getDeliveryPartnerById/{id}")
    Call<DeliveryPartner> getDeliveryPartnerById(@Path("id") int partnerid);

    @POST("/api/DeliveryPartners/addDeliveryPartner")
    Call<DeliveryPartner> addDeliveryPartner(@Body DeliveryPartner partner);

    @PUT("/api/DeliveryPartners/updateDeliveryPartner")
    Call<DeliveryPartner> updateDeliveryPartner(@Body DeliveryPartner partner);

    @DELETE("/api/DeliveryPartners/deleteDeliveryPartnerById/{id}")
    Call<Void> deleteDeliveryPartnerById(@Path("id") int id);
}
