package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;
import com.example.sintomedic.Controllers.Controller;
import com.example.sintomedic.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPaciente extends AppCompatActivity {

    Intent intentUsuario = getIntent();
    String idUsuario = intentUsuario.getStringExtra(LoginActivity.EXTRA_MESSAGE);

    TextView txt_listaDoctores;
    TextView lista_doctores;
    TextView txt_tratamiento;
    TextView tratamiento_paciente;
    TextView txt_calendario;
    Button button_ver_sintomas;
    Button button_add_sympton;

    SintoMedicAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paciente);

        setTitle("Paciente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_listaDoctores =  findViewById(R.id.txt_listaDoctores);
        lista_doctores =  findViewById(R.id.lista_doctores);
        txt_tratamiento =  findViewById(R.id.txt_tratamiento);
        tratamiento_paciente =  findViewById(R.id.tratamiento_paciente);
        txt_calendario =  findViewById(R.id.txt_calendario);
        button_ver_sintomas =  findViewById(R.id.button_ver_sintomas_activity_paciente);
        button_add_sympton =  findViewById(R.id.button_add_sympton_activity_paciente);

        api=APIUtils.getAPIService();

        button_ver_sintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hay que saber a que paciente se PIDE el sintoma

                List<Sintoma> sintomaList = new ArrayList<Sintoma>();

                Intent intent = new Intent (v.getContext(), Controller.class);

                //String jsonDoctor = gsonDoctor.toJson(doctor);
                //intent.putExtra("jsonDoctor", jsonDoctor);
                startActivity(intent);

            }
        });


        button_add_sympton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saber a que usuario se POSTEA
                //Usuario paciente = new Paciente();


                Intent intent = new Intent (v.getContext(), ShowSintomaPacienteActivity.class);

                //String jsonsintoma = gsonsintoma.toJson(sintoma);
                //intent.putExtra("jsonsintoma", jsonsintoma);
                startActivity(intent);

            }
        });







    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.paciente_menu, menu);
        return true;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
