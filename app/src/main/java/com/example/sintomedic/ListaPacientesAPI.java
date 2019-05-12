package com.example.sintomedic;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListaPacientesAPI {
    @GET("pacientes")
    Call<List<Paciente>> loadPacientes();



}
