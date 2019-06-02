package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;
import com.example.sintomedic.Controllers.Controller;
import com.google.gson.Gson;

public class PacienteRegisterActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellidos;
    EditText companiaAseguradora;
    EditText dniNie;
    EditText localidad;
    EditText correo;
    EditText telefono;
    EditText contrasenia;
    
    TextView tvname;
            TextView tvsurname;
    TextView tvcompania;
    TextView tvdni;
            TextView tvloc;
    TextView tvmail;
            TextView tvtelefono;
    TextView tvcontrasenia;

    Button btnRegister;
    Button btnDel;

    SintoMedicAPI api;

    Gson gsonPaciente = new Gson();
    public static final int TXT_REQ =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        setTitle("Registro de paciente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre =  findViewById(R.id.paciente_name);
        apellidos =  findViewById(R.id.paciente_surname);
        companiaAseguradora =  findViewById(R.id.paciente_compania);
        dniNie =  findViewById(R.id.dni_nie_paciente);
        localidad =  findViewById(R.id.place_paciente);
        correo =  findViewById(R.id.mail_paciente);
        telefono =  findViewById(R.id.phone_paciente);
        contrasenia =  findViewById(R.id.pass_paciente);

        tvname = (TextView) findViewById(R.id.txt_namepaciente);
        tvsurname = (TextView) findViewById(R.id.txt_surnamepaciente);
        tvcompania = (TextView) findViewById(R.id.txt_companiapaciente);
        tvdni            = findViewById(R.id.txt_dninie_paciente);
        tvloc = (TextView) findViewById(R.id.txt_placepaciente);
        tvmail = (TextView) findViewById(R.id.txt_mailpaciente);
        tvtelefono = (TextView) findViewById(R.id.txt_phonepaciente);
        tvcontrasenia =  findViewById(R.id.txt_pass_pac);

        btnRegister = findViewById(R.id.button_registro_paciente);
        btnDel = findViewById(R.id.btn_delete_campos_paciente);

        //api=APIUtils.getAPIService();


        Intent intent = getIntent();
        //addListenerOnButton();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario paciente = new Usuario();
                paciente.setApellidos(nombre.getText().toString());
                paciente.setNombre(apellidos.getText().toString());
                paciente.setCompaniaAseguradora(companiaAseguradora.getText().toString());
                paciente.setDNI_NIE(dniNie.getText().toString());
                paciente.setLocalidad(localidad.getText().toString());
                paciente.setCorreo(correo.getText().toString());
                paciente.setTelefono(telefono.getText().toString());
                paciente.setEs_doctor(false);



                //si quero poasar paciente entero no puedo pasarlo por el bundle
                //implementar parseable
                //pasasrlo a json y pasarlo al otro activity con string
                //pa ciente to json y luego al reves
                // web para consultar para hacer el parceable
                //https://coderwall.com/p/vfbing/passing-objects-between-activities-in-android

                // con json mucho mas facil!! https://sites.google.com/site/gson/gson-user-guide
                //objeto a string va en el adapter
                // y deserialization va en la otra clase ShowactivityPaciente
                Intent intent = new Intent (v.getContext(), Controller.class);
                String jsonPaciente = gsonPaciente.toJson(paciente);
                intent.putExtra("jsonPaciente", jsonPaciente);
                startActivity(intent);

            }
        });
    }





    /*public void addListenerOnButton() {

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
*/


}
