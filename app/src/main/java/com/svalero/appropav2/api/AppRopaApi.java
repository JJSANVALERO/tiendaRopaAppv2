package com.svalero.appropav2.api;

import static com.svalero.appropav2.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRopaApi {

    public static AppRopaApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AppRopaApiInterface.class);
    }
}
