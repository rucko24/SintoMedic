package com.example.sintomedic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import com.example.sintomedic.Adapters.PacienteAdapter;
import com.example.sintomedic.Controllers.Controller;

public class MainActivityDoctor extends AppCompatActivity implements Controller.ServerResponse {

    //recibira un intent con EL ID DEL DOCTOR LOGEADO!!!!!!!!!
    private  List<Usuario> pacientesList;
    EditText pacienteAbuscar;
    TextView tagNombrePaciente;
    TextView tagApellidoPaciente;
    TextView nombrePaciente;
    TextView apellidoPaciente;
    Button addPaciente;


    PacienteAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doctor);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pacienteAbuscar=findViewById(R.id.editText_paciente_a_buscar_de_activity_doctor);
        tagNombrePaciente=findViewById(R.id.txt_nombre_paciente_buscado);
        tagApellidoPaciente=findViewById(R.id.txt_apellidos_paciente_buscado);
        nombrePaciente=findViewById(R.id.nombre_paciente_buscado);
        apellidoPaciente=findViewById(R.id.apellidos_paciente_buscado);
        addPaciente=findViewById(R.id.button_add_paciente_a_listapacientes);
        addPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pacienteBuscado=pacienteAbuscar.getText().toString().trim();
                //enviar consulta con ese string a bbdd

                //devolver la consulta a la activity esta!


            }
        });



        RecyclerView recycler = findViewById(R.id.recyclerListaPacientes);
        adapter = new PacienteAdapter(this,null);
        recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        Controller controllerDoctor = new Controller(this);
        //metodo para pedir todos usuarios de X doctor
        controllerDoctor.loadPacientesDoctor();
        // genero una adaptador tipo pacientes para ver los pacientes


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.doctor_menu, menu);
        return true;
    }


    @Override
    public void onResponseSintomas(List<Sintoma> sintomas) {

    }

    @Override
    public void onResponseLogin(Usuario usuario) {

    }

    @Override
    public void onResponseUsuarios(List<Usuario> usuarios) {

    }

    @Override
    public void onResponseUsuario(Usuario usuario) {

    }


}
