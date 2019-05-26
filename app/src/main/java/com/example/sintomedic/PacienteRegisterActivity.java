package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PacienteRegisterActivity extends AppCompatActivity {

    public static final int TXT_REQ =1;
    Button botonRegistroPaciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        Intent intent = getIntent();
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        botonRegistroPaciente =  findViewById(R.id.button_registro_paciente);
        botonRegistroPaciente.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText name = findViewById(R.id.doctor_name);
                EditText surname = findViewById(R.id.doctor_surname);
                EditText jobcenter = findViewById(R.id.centro_medico);
                EditText dni_nie = findViewById(R.id.dni_nie_doctor);
                EditText place = findViewById(R.id.place_doctor);
                EditText mail = findViewById(R.id.mail_doctor);
                EditText phone = findViewById(R.id.phone_doctor);
                EditText license = findViewById(R.id.license_number);


                Intent intentPaciente = new Intent(view.getContext(),  SendRegisterData.class);
                intentPaciente.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//sirve para algo?
                startActivityForResult(intentPaciente, 0);

            }
        });
    }



}
