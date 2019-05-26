package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorRegisterActivity extends AppCompatActivity {

    Button botonRegistroDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_doctor);
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        botonRegistroDoctor =  findViewById(R.id.button_registro_doctor);
        botonRegistroDoctor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText name = findViewById(R.id.doctor_name);
                EditText surname = findViewById(R.id.paciente_surname);
                EditText jobcenter = findViewById(R.id.paciente_compania);
                EditText dni_nie = findViewById(R.id.dni_nie_paciente);
                EditText place = findViewById(R.id.place_paciente);
                EditText mail = findViewById(R.id.mail_paciente);
                EditText phone = findViewById(R.id.phone_paciente);
                

                Intent intentDoctor = new Intent(view.getContext(),  SendRegisterData.class);
                intentDoctor.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//sirve para algo?
                startActivityForResult(intentDoctor, 0);

            }
        });
    }


}
