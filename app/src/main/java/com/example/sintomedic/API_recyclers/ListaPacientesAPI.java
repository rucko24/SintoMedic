package com.example.sintomedic.API_recyclers;


import com.example.sintomedic.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListaPacientesAPI {
    @GET("pacientes")
    Call<List<Paciente>> loadPacientes();



}
