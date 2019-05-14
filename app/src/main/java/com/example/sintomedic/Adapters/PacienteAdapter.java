package com.example.sintomedic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.sintomedic.GlideApp;
import com.example.sintomedic.MainActivityDoctor;
import com.example.sintomedic.Paciente;
import com.example.sintomedic.R;
import com.example.sintomedic.ShowFichaPacienteActivity;

import static android.support.v4.content.ContextCompat.startActivity;


public class PacienteAdapter extends RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder> {


    List<Paciente> pacientesList;
    LayoutInflater inflater;
    Context context;

    public PacienteAdapter(Context context, List<Paciente> pacientesList){
        this.pacientesList = pacientesList;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }



    public class PacienteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView txtName;
        TextView txtSurname;
        Button txtFicha;


        public PacienteViewHolder(View view){
            super(view);
            imgThumbnail = view.findViewById(R.id.imageView_paciente);
            txtName = view.findViewById(R.id.txt_nombre_paciente_item);
            txtSurname = view.findViewById(R.id.txt_apellido_paciente_item);
            txtFicha=view.findViewById(R.id.button_detalles_paciente);
            /*Al apretar en Ver detalle sedl recycler view que abra otra activity*/
            txtFicha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), ShowFichaPacienteActivity.class);
                    startActivity(intent);
                }
            });
        }

        private void startActivity(Intent intent) {
        }
    }



    public void setData(List<Paciente> newList){
        pacientesList = newList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PacienteViewHolder(inflater.inflate(R.layout.listapacientes_item,viewGroup,false));
    }


    @Override
    public void onBindViewHolder(@NonNull PacienteViewHolder vh, int i) {
        Paciente paciente = pacientesList.get(i);
        vh.txtName.setText(paciente.getNombre());
        GlideApp.with(context)
                .load(paciente.getFotoPaciente())
                .into(vh.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        if(pacientesList==null){
            return 0;
        }
        return pacientesList.size();
    }

}
