package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sintomedic.Adapters.SintomaAdapter;
import com.example.sintomedic.Controllers.Controller;
import com.google.gson.Gson;

import java.util.List;

public class ShowFichaPacienteActivity extends AppCompatActivity implements Controller.ServerResponse {
    private ImageView imagenPaciente;
    private TextView txtNombre;
    private TextView txtApellidos;
    private TextView txtFechaNacimiento;
    private TextView txtCompania;
    private TextView txtEnfermedades;

    SintomaAdapter adapter;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // carga la ficha usuario paciente
        setContentView(R.layout.activity_show_fichapaciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Controller controller = new Controller(this);
        //cargo usuaio buscado
        controller.loadUser();
        //preparo adaptador de SINTOMAS
        adapter = new SintomaAdapter(this,null);// ojo que le pasamos null al principio!!
        //preparo el recycler lista sintomas
        RecyclerView recycler = findViewById(R.id.recyclerListaSintomas);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        //HABRA QUE RECIBIR LOS DATOS , EL PACIENTE ENTERO
        Intent intent = getIntent();
        String jsonPaciente = intent.getStringExtra("jsonPaciente");
        //Creamos un nuevo Paciente a partir de json
        Usuario paciente = gson.fromJson(jsonPaciente, Usuario.class);//YA TENEMOS EL PACIENTE


        //relacionar con lo que hay en activity_show_fichapaciente
        imagenPaciente =findViewById(R.id.imagen_ficha_paciente);
        txtNombre=findViewById(R.id.nombre_ficha_paciente);
        txtApellidos=findViewById(R.id.apellido_ficha_paciente);
        txtFechaNacimiento=findViewById(R.id.nacimiento_fecha_paciente);
        txtCompania=findViewById(R.id.txt_compania_paciente);


    }

    @Override
    public void onResponseUsuario(Usuario paciente) {
        //ESE paciente ES EL QUE LLEGA DESSDE ARRIBA?????
        //conseguir foto y cargarla en activity_show_fichapaciente
        /*GlideApp.with(context)
                .load(usuario.getLink_foto_perfil())
                .into(usuario.)*/;
        txtNombre.setText(paciente.getNombre());
        txtApellidos.setText(paciente.getApellidos());
        txtFechaNacimiento.setText((CharSequence) paciente.getFechaNacimiento());
        txtCompania.setText(paciente.getCompanya_Aseguradora());



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




}
