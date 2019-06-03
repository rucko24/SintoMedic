package com.example.sintomedic;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * DoctorRegisterActivity
 */
public class DoctorRegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellidos;
    private EditText centro;
    private EditText dniNie;
    private EditText localidad;
    private EditText correo;
    private EditText telefono;
    private EditText numColegiado;
    private EditText contrasenia;

    private TextView tvname;
    private TextView tvsurname;
    private TextView tvcentro;
    private TextView tvdni;
    private TextView tvloc;
    private TextView tvmail;
    private TextView tvtelefono;
    private TextView tvnumcolegiado;
    private TextView tvcontrasenia;

    Button botonRegistroDoctor;
    Button btnDel;
    Gson gsonDoctor = new Gson();

    private SintoMedicAPI sintoMedicAPI = APIUtils.getApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_doctor);
        setTitle("Registro de doctor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.doctor_name);
        apellidos = findViewById(R.id.doctor_surname);
        centro = findViewById(R.id.centro_medico);
        dniNie = findViewById(R.id.dni_nie_doctor);
        localidad = findViewById(R.id.place_doctor);
        correo = findViewById(R.id.mail_doctor);
        telefono = findViewById(R.id.phone_doctor);
        numColegiado = findViewById(R.id.license_number);
        contrasenia = findViewById(R.id.pass_doctor);

        tvname = (TextView) findViewById(R.id.txt_doctorname);
        tvname.setText("Nombre");
        tvsurname = (TextView) findViewById(R.id.txt_doctorsurname);
        tvsurname.setText("Apellido");
        tvcentro = (TextView) findViewById(R.id.txt_clinica);
        tvcentro.setText("Centro medico");
        tvdni = findViewById(R.id.txt_dninieDoctor);
        tvloc = (TextView) findViewById(R.id.txt_placeDoctor);
        tvmail = (TextView) findViewById(R.id.txt_mailDoctor);
        tvmail.setText("Email");
        tvtelefono = (TextView) findViewById(R.id.txt_phoneDoctor);
        tvnumcolegiado = findViewById(R.id.txt_numcolegiado);
        tvcontrasenia = findViewById(R.id.txt_pass_doctor);

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

        final String email = correo.getText().toString();
        if((!Patterns.EMAIL_ADDRESS.matcher(email).matches()) || email.isEmpty()) {
            correo.setError("Correo invalido");
            correo.requestFocus();
            return;
        }else {
            doctor.setCorreo(email);
        }
        doctor.setCorreo(correo.getText().toString());

        doctor.setTelefono(telefono.getText().toString());
        doctor.setContrasenia(contrasenia.getText().toString());
        doctor.setEs_doctor(true);//provisionalmente se deberia setear a False!!
        //COMO LE PONGO EL ID IGUAL AL ID AUTOGENERADO??
        doctor.setId_lista_doctores(doctor.getId());
        doctor.setId_lista_pacientes(doctor.getId());

        //SintoMedicAPI api=retrofit.create(SintoMedicAPI.class);

        final Call<Usuario> usuarios = sintoMedicAPI.createUser2(doctor);
        usuarios.enqueue(new Callback<Usuario>() {

            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (!response.isSuccessful()) {
                    System.out.print("Response error " + response.code());
                }



                new AlertDialog.Builder(DoctorRegisterActivity.this)
                     .setTitle("Dialog Simple")
                      .setMessage("Doctor registrodo: " + response.body().getId())
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int id) {

                               dialog.cancel();   
                              }
                      }).show();

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println("Error failure: " + t.getMessage());
            }
        });


    }


}
