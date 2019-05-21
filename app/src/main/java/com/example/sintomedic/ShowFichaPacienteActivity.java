package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

public class ShowFichaPacienteActivity extends AppCompatActivity {
    SintomaAdapter adapter;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_sintomas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //recycler View de sintomas de cada paciente:
        ControllerSintomas controllerSintomas = new ControllerSintomas(this);
        controllerSintomas.start();

        adapter = new SintomaAdapter(this);

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




}
