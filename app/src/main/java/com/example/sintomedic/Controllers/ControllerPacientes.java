package com.example.sintomedic.Controllers;

import android.util.Log;

import com.example.sintomedic.API_recyclers.ListaPacientesAPI;
import com.example.sintomedic.Paciente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerPacientes implements Callback<List<Paciente>> {

    private static final String BASE_URL = "http://84.123.198.249:8080/";//mi IP casa + pto APiSpring diferente 8080!!!!!
    private ServerResponse handler;


    public ControllerPacientes(ServerResponse handler){
        this.handler = handler;
    }

    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ListaPacientesAPI api = retrofit.create(ListaPacientesAPI.class);

        Call<List<Paciente>> call = api.loadPacientes();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
        if(response.isSuccessful()){
            List<Paciente> pacientes = response.body();
            if(pacientes.size()>0){
                Log.d("ControllerPacientes", pacientes.get(0).getNombre());
                handler.onResponse(pacientes);
            }
        }else{
            Log.d("ControllerPacientes", response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<List<Paciente>> call, Throwable t) {
        t.printStackTrace();
    }

    public interface ServerResponse {
        void onResponse(List<Paciente> movies);
    }
}
