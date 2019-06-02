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

import org.apache.http.params.HttpParams;

public class DoctorRegisterActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellidos;
    EditText centro;
    EditText dniNie;
    EditText localidad;
    EditText correo;
    EditText telefono;
    EditText numColegiado;
    EditText contrasenia;

    TextView tvname;
    TextView tvsurname;
    TextView tvcentro;
    TextView tvdni;
    TextView tvloc;
    TextView tvmail;
    TextView tvtelefono;
    TextView tvnumcolegiado;
    TextView tvcontrasenia;

    Button btnRegister;
    Button btnDel;

    SintoMedicAPI api;

    Gson gsonDoctor = new Gson();

    Button botonRegistroDoctor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_doctor);
        setTitle("Registro de doctor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre =  findViewById(R.id.doctor_name);
        apellidos =  findViewById(R.id.doctor_surname);
        centro =  findViewById(R.id.centro_medico);
        dniNie =  findViewById(R.id.dni_nie_doctor);
        localidad =  findViewById(R.id.place_doctor);
        correo =  findViewById(R.id.mail_doctor);
        telefono =  findViewById(R.id.phone_doctor);
        numColegiado =  findViewById(R.id.license_number);
        contrasenia =  findViewById(R.id.pass_doctor);

        tvname = (TextView) findViewById(R.id.txt_doctorname);
        tvsurname = (TextView) findViewById(R.id.txt_doctorsurname);
        tvcentro = (TextView) findViewById(R.id.txt_clinica);
        tvdni            = findViewById(R.id.txt_dninieDoctor);
        tvloc = (TextView) findViewById(R.id.txt_placeDoctor);
        tvmail = (TextView) findViewById(R.id.txt_mailDoctor);
        tvtelefono = (TextView) findViewById(R.id.txt_phoneDoctor);
        tvnumcolegiado =  findViewById(R.id.txt_numcolegiado);
        tvcontrasenia =  findViewById(R.id.txt_pass_doctor);

        botonRegistroDoctor = findViewById(R.id.button_registro_doctor);
        btnDel = findViewById(R.id.button_eliminar_datos_doctor);

        //api=APIUtils.getAPIService();

        botonRegistroDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario doctor = new Usuario();
                doctor.setApellidos(nombre.getText().toString());
                doctor.setNombre(apellidos.getText().toString());
                doctor.setCentro_medico(centro.getText().toString());
                doctor.setDNI_NIE(dniNie.getText().toString());
                doctor.setLocalidad(localidad.getText().toString());
                doctor.setCorreo(correo.getText().toString());
                doctor.setTelefono(telefono.getText().toString());
                doctor.setContrasenia(contrasenia.getText().toString());

                Intent intent = new Intent (v.getContext(), Controller.class);

                String jsonDoctor = gsonDoctor.toJson(doctor);

                //postData("http://your/login/url",jsonDoctor);
                intent.putExtra("jsonDoctor", jsonDoctor);
                startActivity(intent);

            }
        });


    }
    //METODO PARA POSTEAR EN SPRING


   /* public void addListenerOnButton() {

        botonRegistroDoctor =  findViewById(R.id.button_registro_doctor);
        botonRegistroDoctor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //Usuario usuario=usuario.get;

                EditText name = findViewById(R.id.doctor_name);
                EditText surname = findViewById(R.id.doctor_surname);
                EditText jobcenter = findViewById(R.id.doctor_compania);
                EditText dni_nie = findViewById(R.id.dni_nie_doctor);
                EditText place = findViewById(R.id.place_doctor);
                EditText mail = findViewById(R.id.mail_doctor);
                EditText phone = findViewById(R.id.phone_doctor);
                
*//*
                Intent intentDoctor = new Intent(view.getContext(),  SendRegisterData.class);
                intentDoctor.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//sirve para algo?
                startActivityForResult(intentDoctor, 0);*//*

            }
        });
    }*/


}
