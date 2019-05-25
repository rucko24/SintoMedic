package com.example.sintomedic.API_recyclers;

import com.example.sintomedic.Paciente;
import com.example.sintomedic.Sintoma;
import com.example.sintomedic.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginAPI extends ListaPacientesAPI {
    @GET("usuarios")
    Call<Usuario> loadUsuario();


}
