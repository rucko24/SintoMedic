package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sintomedic.Adapters.PacienteAdapter;
import com.example.sintomedic.Controllers.Controller;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShowFichaPacienteActivity extends AppCompatActivity implements Controller.ServerResponse {
    PacienteAdapter adapter;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_sintomas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //recycler View de sintomas de cada paciente:
        Controller controllerSintomas = new Controller(this);
        controllerSintomas.loadPacientes();

        adapter = new PacienteAdapter(this,null);// ojo que le pasamos null al principio!!

        RecyclerView recycler = findViewById(R.id.recyclerListaPacientes);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        String jsonPaciente = intent.getStringExtra("jsonPaciente");
        //Creamos un objeto Gson

        //Creamos un nuevo Paciente a partir de json
        Paciente paciente = gson.fromJson(jsonPaciente, Paciente.class);


    }


    @Override
    public void onResponseSintomas(List<Sintoma> sintomas) {

    }

    @Override
    public void onResponseLogin(Usuario usuario) {

    }

    @Override
    public void onResponsePacientes(List<Paciente> pacientes) {

    }
}
