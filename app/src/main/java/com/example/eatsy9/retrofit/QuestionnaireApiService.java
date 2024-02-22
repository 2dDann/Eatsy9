package com.example.eatsy9.retrofit;

import com.example.eatsy9.model.Questionnaire;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface QuestionnaireApiService {

    @POST("/api/questionnaire/saveQuestionnaire")
    Call<Questionnaire> saveQuestionnaire(@Body QuestionnaireDto questionnaireDto);
}

