package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PacienteRegisterActivity extends AppCompatActivity {

    //UserService userService;
    EditText name;
    EditText surname;
    EditText compania;
    EditText dni;
    EditText loc;
    EditText mail;
    EditText telefono;

    TextView tvname
            TextView tvsurname;
    TextView tvcompania;
    TextView tvdni;
            TextView tvloc;
    TextView tvmail;
            TextView tvtelefono;

    Button btnRegister;
    Button btnDel;



    public static final int TXT_REQ =1;
    Button botonRegistroPaciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        setTitle("Registro de paciente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.paciente_name);
        surname = (EditText) findViewById(R.id.paciente_surname);
        compania = (EditText) findViewById(R.id.paciente_compania);
        dni = (EditText) findViewById(R.id.dni_nie_paciente);
        loc = (EditText) findViewById(R.id.place_paciente);
        mail = (EditText) findViewById(R.id.mail_paciente);
        telefono = (EditText) findViewById(R.id.phone_paciente);

        tvname = (TextView) findViewById(R.id.txt_namepaciente);
        tvsurname = (TextView) findViewById(R.id.txt_surnamepaciente);
        tvcompania = (TextView) findViewById(R.id.txt_companiapaciente);
        tvdni            = (TextView) findViewById(R.id.txt_dninie_paciente);
        tvloc = (TextView) findViewById(R.id.txt_placepaciente);
        tvmail = (TextView) findViewById(R.id.txt_mailpaciente);
        tvtelefono = (TextView) findViewById(R.id.txt_phonepaciente);


        btnRegister = (Button) findViewById(R.id.button_registro_paciente);
        btnDel = (Button) findViewById(R.id.btn_delete_campos_paciente);

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
