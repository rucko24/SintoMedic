package com.example.sintomedic.Controllers;

import android.util.Log;

import com.example.sintomedic.API_recyclers.ListaSintomasAPI;
import com.example.sintomedic.Sintoma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerSintomas implements Callback<List<Sintoma>> {

    private static final String BASE_URL = "http://84.123.198.249:8080/";//mi IP casa + pto APiSpring diferente 8080!!!!!
    private ServerResponse handler;


    public ControllerSintomas(ServerResponse handler){
        this.handler = handler;
    }

    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ListaSintomasAPI api = retrofit.create(ListaSintomasAPI.class);

        Call<List<Sintoma>> call = api.loadSintomas();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Sintoma>> call, Response<List<Sintoma>> response) {
        if(response.isSuccessful()){
            List<Sintoma> sintomas = response.body();
            if(sintomas.size()>0){
                Log.d("ControllerSintomas", sintomas.get(0).getIdPaciente());
                //ojo que hemos forzado a que devuelev un String!! revisar
                handler.onResponse(sintomas);
            }
        }else{
            Log.d("ControllerSintomas", response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<List<Sintoma>> call, Throwable t) {
        t.printStackTrace();
    }

    public interface ServerResponse {
        void onResponse(List<Sintoma> sintomaList);
    }
}
