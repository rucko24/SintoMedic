package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AddSintomaPacienteActivity extends AppCompatActivity {


    private EditText descripcion;
    private EditText temp;
    private EditText pres;
    private EditText puls;
    private Button sendSintomaButton;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // carga la ficha usuario paciente
        setContentView(R.layout.activity_add_sintoma_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //HABRA QUE RECIBIR LOS DATOS , EL PACIENTE ENTERO
        Intent intent = getIntent();
        String jsonSintoma = intent.getStringExtra("jsonSintoma");
        //Creamos un nuevo Paciente a partir de json
        final Sintoma sintoma= gson.fromJson(jsonSintoma, Sintoma.class);//YA TENEMOS El sintoma

        descripcion=findViewById(R.id.descripcion_simtoma_toadd);
        temp=findViewById(R.id.temperatura_send);
        pres=findViewById(R.id.tension_send);
        puls=findViewById(R.id.pulso_send);
        sendSintomaButton=findViewById(R.id.button_send_sintoma);

        sendSintomaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sintoma.setDescripcion(descripcion.getText().toString());
                sintoma.setTemperatura(Float.valueOf(temp.getText().toString()));
                sintoma.setPresionArterial(Float.valueOf(pres.getText().toString()));





            }
        });















    }

}
