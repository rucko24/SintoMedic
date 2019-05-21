package com.example.sintomedic.API_recyclers;

import com.example.sintomedic.Sintoma;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListaSintomasAPI {
    @GET("sintomas")
    Call<List<Sintoma>> loadSintomas();



}
