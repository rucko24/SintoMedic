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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sintomedic.RetrofitClient.retrofit;

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
                //METODO CREAR EL DOCTOR!!
                createDoctor();
                /*Intent intent = new Intent (v.getContext(), Controller.class);
                String jsonDoctor = gsonDoctor.toJson(doctor);
                //postData("http://your/login/url",jsonDoctor);
                intent.putExtra("jsonDoctor", jsonDoctor);
                startActivity(intent);*/
            }
        });


    }

    private void createDoctor() {

            final Usuario doctor = new Usuario();
            doctor.setApellidos(nombre.getText().toString());
            doctor.setNombre(apellidos.getText().toString());
            doctor.setCentro_medico(centro.getText().toString());
            doctor.setDNI_NIE(dniNie.getText().toString());
            doctor.setLocalidad(localidad.getText().toString());
            doctor.setCorreo(correo.getText().toString());
            doctor.setTelefono(telefono.getText().toString());
            doctor.setContrasenia(contrasenia.getText().toString());
            doctor.setEs_doctor(true);//provisionalmente se deberia setear a False!!
            //COMO LE PONGO EL ID IGUAL AL ID AUTOGENERADO??
            doctor.setId_lista_doctores(doctor.getId());
            doctor.setId_lista_pacientes(doctor.getId());

            SintoMedicAPI api=retrofit.create(SintoMedicAPI.class);
            Call<Usuario> usuarios = api.createUser2(doctor);
            usuarios.enqueue(new Callback<Usuario>() {

                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    if(!response.isSuccessful()) {
                        System.out.print("Response error " + response.code());
                    }

                    final Usuario usuarioResponse = response.body();
                    final StringBuilder sb = new StringBuilder();
                    sb.append("" + usuarioResponse.getNombre());
                    sb.append(usuarioResponse.getApellidos());
                    sb.append(usuarioResponse.getCorreo());
                    sb.append(usuarioResponse.getDNI_NIE());
                    sb.append(usuarioResponse.getNum_colegiado());
                    sb.append(usuarioResponse.getId_lista_pacientes());
                    sb.append(usuarioResponse.getId_lista_pacientes());
                    sb.append(usuarioResponse.isEs_doctor());
                    sb.append(usuarioResponse.getLink_foto_perfil());
                    sb.append(usuarioResponse.getContrasenia());

                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    System.out.println("Error failure: " + t.getMessage());
                }
            });


    }



}
