package com.example.sintomedic.Controllers;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;
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

public class Controller    {
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
    //LOGIN
    public void login( String dni_nie, String pass){
        Call<Usuario> call = api.loginUser(dni_nie,pass);
        call.enqueue(new Callback<Usuario>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario usuario = response.body();
                    if(usuario!=null) {
                        Log.d("CONTROLLER nombre user:", usuario.getNombre());
                        handler.onResponseLogin(usuario);
                    }
                }else{
                    Log.d("error en CONTROLLER login usuario", response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {t.printStackTrace();}

        });


    }
    //CREAR USUARIO
    public void createUser(){
        Call <Usuario> call = api.createUser();
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario>  response) {
                if(response.isSuccessful()){
                    Usuario usuario = response.body();
                    if(usuario!=null) {
                        Log.d("CONTROLLER pacientes", usuario.getNombre());
                        //handler.onResponseUsuarios((List<Usuario>) usuario);
                    }
                }else{
                    Log.d("Controller", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {t.printStackTrace();}
        });

    }

    //CARGAR LOS PACIENTES DE X DOCTOR
    public void loadPacientesDoctor(){
        //OJO HABRA QUE CAMBIARLO
        int id_listadoctores=1;
        Call <List<Usuario>> call = api.listUsers(id_listadoctores);
        call.enqueue(new Callback<List<Usuario>>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful()){
                    List<Usuario> usuariosList = response.body();
                    if(usuariosList.size()>0) {
                        Log.d("CONTROLLER paciente 1 es:", usuariosList.get(0).getNombre());
                        handler.onResponseUsuarios(usuariosList);
                    }
                }else{
                    Log.d("Controller", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {t.printStackTrace();}
        });
    }

    //CARGAR X DOCTOR
    public void loadDoctorX(){

        Call <Usuario> call = api.listUser();
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario usuario = response.body();
                    if(usuario!=null) {
                        Log.d("CONTROLLER pacientes", usuario.getNombre());
                        //handler.onResponseUsuarios((List<Usuario>) usuario);
                    }
                }else{
                    Log.d("Controller", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {t.printStackTrace();}
        });
    }

    //CARGAR X USUARIO
    public void loadUser(){

        Call<Usuario> call = api.listUser();
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario usuario = response.body();
                    if(usuario!=null) {
                        Log.d("CONTROLLER pacientes", usuario.getNombre());
                        handler.onResponseUsuario((Usuario) usuario);
                    }
                }else{
                    Log.d("Controller", response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {t.printStackTrace();}
        });
    }


    //CARGAR SINTOMAS DE 1 PACIENTE
    public void downloadSintomas(){
        Call<List<Sintoma>> call = api.listSintomas();
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

    //POSTEAR SINTOMAS DE 1 PACIENTE
    public void loadSintomas(){
        Call<List<Sintoma>> call = api.createSintoma();
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

        void onResponseUsuarios(List<Usuario> usuarios);

        void onResponseUsuario(Usuario usuario);
    }



}
