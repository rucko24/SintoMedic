package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sintomedic.Adapters.PacienteAdapter;
import com.example.sintomedic.Adapters.SintomaAdapter;
import com.example.sintomedic.Controllers.Controller;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShowFichaPacienteActivity extends AppCompatActivity implements Controller.ServerResponse {
    SintomaAdapter adapter;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // carga la ficha usuario paciente
        setContentView(R.layout.ficha_paciente_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Controller controller = new Controller(this);
        //cargo usuaio buscado
        controller.loadUser();
        //preparo adaptador de SINTOMAS
        adapter = new SintomaAdapter(this,null);// ojo que le pasamos null al principio!!
        //preparo el recycler lista sintomas
        RecyclerView recycler = findViewById(R.id.recyclerListaSintomas);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        //HABRA QUE RECIBIR LOS DATOS , EL PACIENTE ENTERO
        Intent intent = getIntent();
        String jsonPaciente = intent.getStringExtra("jsonPaciente");
        //Creamos un nuevo Paciente a partir de json
        Paciente paciente = gson.fromJson(jsonPaciente, Paciente.class);//YA TENEMOS EL PACIENTE


    }


    @Override
    public void onResponseSintomas(List<Sintoma> sintomas) {

    }

    @Override
    public void onResponseLogin(Usuario usuario) {

    }

    @Override
    public void onResponseUsuarios(List<Usuario> usuarios) {

    }

    @Override
    public void onResponseUsuario(Usuario usuario) {

    }


}
