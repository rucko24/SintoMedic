package com.example.sintomedic.Controllers;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.sintomedic.API_recyclers.ListaPacientesAPI;
import com.example.sintomedic.API_recyclers.ListaSintomasAPI;
import com.example.sintomedic.API_recyclers.LoginAPI;
import com.example.sintomedic.API_recyclers.SintoMedicAPI;
import com.example.sintomedic.Paciente;
import com.example.sintomedic.Sintoma;
import com.example.sintomedic.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller   {
    private static final String BASE_URL = "http:/84.123.198.249:8080/";//IP + pto APiSpring !!!!!
    private ServerResponse handler;
    public Controller(ServerResponse handler){
        this.handler = handler;
    }

    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    SintoMedicAPI api=retrofit.create(SintoMedicAPI.class);

    public void login(){
        Call<Usuario> call = api.loadUsuario();
        call.enqueue(new Callback<Usuario>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario usuario = response.body();
                    if(usuario!=null) {
                        Log.d("CONTROLLER", usuario.getNombre());
                        handler.onResponseLogin(usuario);
                    }
                }else{
                    Log.d("error en CONTROLLER usuario", response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {t.printStackTrace();}

        });


    }
    public void loadPacientes(){

        Call<List<Paciente>> call = api.loadPacientes();
        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
                if(response.isSuccessful()){
                    List<Paciente> pacientes = response.body();
                        if(pacientes.size()>0) {
                            Log.d("CONTROLLER pacientes", pacientes.get(0).getNombre());
                            handler.onResponsePacientes(pacientes);
                        }
                }else{
                    Log.d("Controller", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {t.printStackTrace();}
        });
    }

    public void downloadSintomas(){
        Call<List<Sintoma>> call = api.downloadSintomas();
        call.enqueue(new Callback<List<Sintoma>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<List<Sintoma>> call, Response<List<Sintoma>> response) {
                if(response.isSuccessful()){
                    List<Sintoma> sintomas = response.body();
                    if(sintomas.size()>0) {
                        Log.d("download sintomas", sintomas.get(0).getDescripcion());
                        handler.onResponseSintomas(sintomas);
                    }
                }else{
                    Log.d("download Sintomas", response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Call<List<Sintoma>> call, Throwable t) {t.printStackTrace();
            }
        });

    }

    public void loadSintomas(){
        Call<List<Sintoma>> call = api.loadSintomas();
        call.enqueue(new Callback<List<Sintoma>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<List<Sintoma>> call, Response<List<Sintoma>> response) {
                if(response.isSuccessful()){
                    List<Sintoma> sintomas = response.body();
                    if(sintomas.size()>0) {
                        Log.d("load sintomas", sintomas.get(0).getDescripcion());
                        handler.onResponseSintomas(sintomas);
                    }
                }else{
                    Log.d("Error load Sintomas", response.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Call<List<Sintoma>> call, Throwable t) {t.printStackTrace();
            }
        });

    }

    public interface ServerResponse {

        void onResponseSintomas(List<Sintoma> sintomas);

        void onResponseLogin(Usuario usuario);

        void onResponsePacientes(List<Paciente> pacientes);
    }



}
