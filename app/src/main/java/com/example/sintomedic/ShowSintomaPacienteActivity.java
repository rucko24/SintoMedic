package com.example.sintomedic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;

public class ShowSintomaPacienteActivity  extends AppCompatActivity {

    private TextView descripcion;
    private TextView temp;
    private TextView pres;
    private TextView puls;



    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // carga la ficha usuario paciente
        setContentView(R.layout.activity_show_sintoma_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //HABRA QUE RECIBIR LOS DATOS , EL PACIENTE ENTERO
        Intent intent = getIntent();
        String jsonSintoma = intent.getStringExtra("jsonSintoma");
        //Creamos un nuevo Paciente a partir de json
        Sintoma sintoma= gson.fromJson(jsonSintoma, Sintoma.class);//YA TENEMOS El sintoma

        descripcion=findViewById(R.id.descripcion_sintoma_ver);
        temp=findViewById(R.id.temperatura_ver);
        pres=findViewById(R.id.tension_ver);
        puls=findViewById(R.id.pulso_ver);

        descripcion.setText(sintoma.getDescripcion());
        temp.setText(String.valueOf(sintoma.getTemperatura()));
        pres.setText(String.valueOf(sintoma.getPresionArterial()));
        puls.setText(sintoma.getPulso());








    }
}
