package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

public class ShowFichaPacienteActivity extends AppCompatActivity {
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha_paciente_item);
        Intent intent = getIntent();
        String jsonPaciente = intent.getStringExtra("jsonPaciente");
        //Creamos un objeto Gson

        //Creamos un nuevo Paciente a partir de json
        Paciente paciente = gson.fromJson(jsonPaciente, Paciente.class);


    }




}
