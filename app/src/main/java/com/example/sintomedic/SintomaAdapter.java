package com.example.sintomedic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sintomedic.Adapters.PacienteAdapter;
import com.google.gson.Gson;

import java.util.List;

class SintomaAdapter extends RecyclerView.Adapter<SintomaAdapter.SintomaViewHolder> {

    List<Sintoma> sintomasList;
    LayoutInflater inflater;
    Context context;
    Gson gsonPaciente = new Gson();

    public SintomaAdapter(Context context,List<Sintoma> sintomasList ) {
        this.sintomasList=sintomasList;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }

    public class SintomaViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha;
        TextView txtHora;
        Button txtVerSintoma;

        public SintomaViewHolder(@NonNull View view) {
            super(view);
            txtFecha = view.findViewById(R.id.fecha_sintoma_paciente);
            txtHora = view.findViewById(R.id.hora_sintoma_pacientete);
            txtVerSintoma = view.findViewById(R.id.button_ver_descripcion_sintoma);


        }
    }

    public void setData(List<Sintoma> newList){
        sintomasList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SintomaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SintomaViewHolder(inflater.inflate(R.layout.listasintomas_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SintomaViewHolder vh, int i) {
        Sintoma sintoma=sintomasList.get(i);
        vh.txtFecha.setText((CharSequence) sintoma.getFechaHora());
        vh.txtHora.setText((CharSequence) sintoma.getFechaHora());

    }



    @Override
    public int getItemCount() {
        if(sintomasList==null){
            return 0;
        }
        return sintomasList.size();

    }


}
