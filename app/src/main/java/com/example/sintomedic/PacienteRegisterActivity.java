package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PacienteRegisterActivity extends AppCompatActivity {

    //UsuarioService UsuarioService;
    EditText name;
    EditText surname;
    EditText compania;
    EditText dni;
    EditText loc;
    EditText mail;
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
    public static final int TXT_REQ =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        setTitle("Registro de paciente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name =  findViewById(R.id.paciente_name);
        surname =  findViewById(R.id.paciente_surname);
        compania =  findViewById(R.id.paciente_compania);
        dni =  findViewById(R.id.dni_nie_paciente);
        loc =  findViewById(R.id.place_paciente);
        mail =  findViewById(R.id.mail_paciente);
        telefono =  findViewById(R.id.phone_paciente);
        telefono =  findViewById(R.id.phone_paciente);

        tvname = (TextView) findViewById(R.id.txt_namepaciente);
        tvsurname = (TextView) findViewById(R.id.txt_surnamepaciente);
        tvcompania = (TextView) findViewById(R.id.txt_companiapaciente);
        tvdni            = findViewById(R.id.txt_dninie_paciente);
        tvloc = (TextView) findViewById(R.id.txt_placepaciente);
        tvmail = (TextView) findViewById(R.id.txt_mailpaciente);
        tvtelefono = (TextView) findViewById(R.id.txt_phonepaciente);
        telefono =  findViewById(R.id.phone_paciente);


        btnRegister = findViewById(R.id.button_registro_paciente);
        btnDel = findViewById(R.id.btn_delete_campos_paciente);

        Intent intent = getIntent();
        //addListenerOnButton();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setApellidos(name.getText().toString());
                u.setNombre(surname.getText().toString());
                u.setCompanya_Aseguradora(compania.getText().toString());
                u.setDNI_NIE(dni.getText().toString());
                u.setLocalidad(loc.getText().toString());
                u.setCorreo(mail.getText().toString());
                u.setTelefono(telefono.getText().toString());

               /* if(UsuarioId != null && UsuarioId.trim().length() > 0){
                    //update Usuario
                    updateUsuario(Integer.parseInt(UsuarioId), u);
                } else {
                    //add Usuario
                    addUsuario(u);
                }*/
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
