package com.example.sintomedic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.List;

import com.example.sintomedic.Adapters.PacienteAdapter;
import com.example.sintomedic.Controllers.Controller;

public class MainActivityDoctor extends AppCompatActivity implements Controller.ServerResponse {
    private  List<Paciente> pacientesList;
    PacienteAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doctor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Controller controllerDoctor = new Controller(this);
        controllerDoctor.start();
        // genero una adaptador tipo pacientes para ver los pacientes

        adapter = new PacienteAdapter(this,null);

        RecyclerView recycler = findViewById(R.id.recyclerListaPacientes);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_menu, menu);
        return true;
    }

    @Override
    public void onResponse(List<Paciente> pacientesList) {

    }
}
