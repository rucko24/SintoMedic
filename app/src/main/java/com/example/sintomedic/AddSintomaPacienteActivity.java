package com.example.sintomedic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sintomedic.API_recyclers.SintoMedicAPI;
import com.google.gson.Gson;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.sintomedic.RetrofitClient.retrofit;

class AddSintomaPacienteActivity extends AppCompatActivity {

    private Long id;
    private EditText descripcion;
    private EditText temperatura;
    private int idPaciente;
    private int idDoctorEnviado;
    private EditText presionArterial;
    private EditText pulso;
    private Button sendSintomaButton;

    private Date fechaHora;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // carga la ficha usuario paciente
        setContentView(R.layout.activity_add_sintoma_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // SOLO RECIBIR EL ID DE PACIENTE PARA LUEGO AÑADIR SINTOMA CON DICHO ID

        //HABRA QUE RECIBIR LOS DATOS , EL PACIENTE y intoma entero
        Intent intent = getIntent();
        String jsonSintoma = intent.getStringExtra("jsonSintoma");
        //Creamos un nuevo Sintoma a partir de json
        final Sintoma sintoma= gson.fromJson(jsonSintoma, Sintoma.class);//YA TENEMOS El sintoma

        descripcion=findViewById(R.id.descripcion_simtoma_toadd);
        temperatura=findViewById(R.id.temperatura_send);
        presionArterial=findViewById(R.id.tension_send);
        pulso=findViewById(R.id.pulso_send);
        sendSintomaButton=findViewById(R.id.button_send_sintoma);

        sendSintomaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSintoma();
            }
        });

    }

    private void createSintoma() {

        final Sintoma sintoma = new Sintoma();
        sintoma.setDescripcion(descripcion.getText().toString());
        sintoma.setTemperatura(Float.valueOf(temperatura.getText().toString()));
        sintoma.setPresionArterial(Float.valueOf(presionArterial.getText().toString()));
        sintoma.setPulso(pulso.getText().toString());
        //sintoma.setIdPaciente();


        SintoMedicAPI api=retrofit.create(SintoMedicAPI.class);
        Call<Sintoma> call = api.createSintoma(sintoma);
        call.enqueue(new Callback<Sintoma>() {

            @Override
            public void onResponse(Call<Sintoma> call, Response<Sintoma> response) {
                if(!response.isSuccessful()) {
                    System.out.print("Response error " + response.code());
                }
                final Sintoma sintomaResponse = response.body();
                final StringBuilder sb = new StringBuilder();
                sb.append("" + sintomaResponse.getDescripcion());
                sb.append(sintomaResponse.getTemperatura());
                sb.append(sintomaResponse.getPresionArterial());
                sb.append(sintomaResponse.getPulso());
                sb.append(sintomaResponse.getId());


            }

            @Override
            public void onFailure(Call<Sintoma> call, Throwable t) {
                System.out.println("Error failure: " + t.getMessage());
            }
        });
        
    }

}
