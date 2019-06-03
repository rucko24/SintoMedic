package com.example.sintomedic;


import com.example.sintomedic.API_recyclers.SintoMedicAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * invocar a getApi para obtener metodo de la interface SintoMedicAPI
 */
public class APIUtils {

    private APIUtils() {
    }

    public static final String API_URL = "http://192.168.1.38:8080"; // tu direccion ip local

    public static SintoMedicAPI getApi() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SintoMedicAPI.class);
    }
}
