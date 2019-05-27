package com.example.sintomedic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import com.example.sintomedic.R;
import com.example.sintomedic.Sintoma;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FichaPacienteAdapter extends RecyclerView.Adapter<FichaPacienteAdapter.FichaPacienteViewHolder> {

    // lista de todos pacientes de X doctor
    private List<Sintoma> sintomasList=new ArrayList<>();
    //Sintoma sintoma;
    LayoutInflater inflater;
    Context context;
    Gson gsonsintoma = new Gson();




    public FichaPacienteAdapter(Context context,  List<Sintoma> sintoma){
        this.sintomasList = sintoma;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }



    public class FichaPacienteViewHolder extends RecyclerView.ViewHolder  {
        //tags del listasintomas_item que inflamos abajo
        TextView fechaSintma;
        TextView horaSintoma;
        Button botonVerSintomas;
        //tag del ShowFichaPacienteActivity SERAN 6!!!




        public FichaPacienteViewHolder(View view){
            super(view);
            fechaSintma=view.findViewById(R.id.fecha_sintoma_paciente);
            horaSintoma=view.findViewById(R.id.hora_sintoma_pacientete);
            botonVerSintomas=view.findViewById(R.id.button_ver_descripcion_sintoma);



            botonVerSintomas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, VerFichaSintoma.class);
                    Sintoma sintoma=  sintomasList.get(getAdapterPosition());

                    String jsonsintoma = gsonsintoma.toJson(sintomasList);
                    intent.putExtra("jsonsintoma", jsonsintoma);
                    startActivity(intent);

                }

                private void startActivity(Intent intent) {
                }
            });        }



    }






    @NonNull
    @Override
    public FichaPacienteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FichaPacienteAdapter.FichaPacienteViewHolder(inflater.inflate(R.layout.listasintomas_item,viewGroup,false));

    }

    //RELLEN LISTA_SINTOMASiTEM
    @Override
    public void onBindViewHolder(@NonNull FichaPacienteAdapter.FichaPacienteViewHolder vh, int i) {
        Sintoma currentSint =  sintomasList.get(i);
        //OJO  FALTA SEPARAR FECHA Y HORA!!!!!!!!!
        vh.fechaSintma.setText((CharSequence) currentSint.getFechaHora());
        vh.horaSintoma.setText((CharSequence) currentSint.getFechaHora());
        //vh.botonVerSintomas.setT

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(List<Sintoma> newList){
        sintomasList = newList;
        notifyDataSetChanged();
    }





}
