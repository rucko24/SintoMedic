package com.example.sintomedic;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "http://#############:8080/demo/";

    public static SintoMedicAPI getAPIService(){
        return RetrofitClient.getClient(API_URL).create(SintoMedicAPI.class);
    }
}
