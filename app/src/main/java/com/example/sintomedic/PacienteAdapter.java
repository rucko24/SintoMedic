package com.example.sintomedic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import com.bumptech.glide.Glide;

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

        TextView txtName;
        TextView txtSurname;
        ImageView imgThumbnail;




        public PacienteViewHolder(View view){
            super(view);
            txtName = view.findViewById(R.id.txt_nombre_paciente_item);
            txtSurname = view.findViewById(R.id.txt_apellido_paciente_item);
            imgThumbnail = view.findViewById(R.id.imageView_paciente);


            // listener al apreter nombre se cambiará a otro
            txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paciente paciente = pacientesList.get(getAdapterPosition());
                    // en lugar de toast que envie a otra activity

                    /*Toast.makeText(
                            context,
                            paciente.getName(),
                            Toast.LENGTH_LONG).show();*/
                }
            });
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
