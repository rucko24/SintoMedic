package com.example.sintomedic.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sintomedic.R;
import com.example.sintomedic.Sintoma;
import com.google.gson.Gson;

import java.util.List;

public class SintomaAdapter extends RecyclerView.Adapter<SintomaAdapter.SintomaViewHolder> {

    List<Sintoma> sintomasList;
    LayoutInflater inflater;
    Context context;
    Gson gsonPaciente = new Gson();

    public SintomaAdapter(Context context,List<Sintoma> sintomasList) {
        this.sintomasList=sintomasList;
        inflater=LayoutInflater.from(context);
        this.context=context;
    }


    public class SintomaViewHolder extends RecyclerView.ViewHolder {
        TextView txtFecha;
        TextView txtHora;
        TextView txtTagFecha;
        TextView txtTagHora;
        Button buttonVerSintoma;

        public SintomaViewHolder(@NonNull View view) {
            super(view);
            txtFecha = view.findViewById(R.id.fecha_sintoma_paciente);
            txtHora = view.findViewById(R.id.hora_sintoma_pacientete);

            txtTagFecha=view.findViewById(R.id.tag_fecha_sintoma_paciente);
            txtTagHora=view.findViewById(R.id.tag_hora_sintoma_paciente);

            buttonVerSintoma = view.findViewById(R.id.button_ver_descripcion_sintoma);

            buttonVerSintoma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Sintoma sintoma=sintomasList.get(getAdapterPosition());
                    //tenemos el sintoma ya, ahora lo pasamos a json y lo enviamos a donde sea



                }
            });


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
