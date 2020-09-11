package com.example.gads_leaderboard.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GadsApiClient {

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    public static final String GOOGLE_DOCS_BASE_URL = "https://docs.google.com/forms/d/e/";

    public static GadsApi getLeadersApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GadsApi gadsApi = retrofit.create(GadsApi.class);
        return gadsApi;
//        final GadsApi gadsApi = retrofit.create(GadsApi.class);
//        return gadsApi;

    }

    public static GadsApi getGoogleDocs(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GOOGLE_DOCS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GadsApi gadsApi = retrofit.create(GadsApi.class);
        return  gadsApi;
    }


}

