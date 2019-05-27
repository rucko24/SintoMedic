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
import com.example.sintomedic.R;
import com.example.sintomedic.ShowFichaPacienteActivity;
import com.example.sintomedic.Usuario;
import com.google.gson.Gson;


public class PacienteAdapter extends RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder> {

    // lista de todos pacientes de X doctor
    List<Usuario> pacientesList;
    LayoutInflater inflater;
    Context context;
    Gson gsonPaciente = new Gson();



    public PacienteAdapter(Context context, List<Usuario> pacientesList){
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
            txtFicha=view.findViewById(R.id.button_ficha_paciente);
            /*Al apretar en Ver detalle sedl recycler view que abra otra activity*/
            txtFicha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, ShowFichaPacienteActivity.class);
                    Usuario paciente = pacientesList.get(getAdapterPosition());
                    //si quiero poasar paciente entero no puedo pasarlo por el bundle
                    //implementar parseable
                    //pasasrlo a json y pasarlo al otro activity con string
                    //pa ciente to json y luego al reves
                    // web para consultar para hacer el parceable
                    //https://coderwall.com/p/vfbing/passing-objects-between-activities-in-android

                    // con json mucho mas facil!! https://sites.google.com/site/gson/gson-user-guide
                    //objeto a string va en el adapter
                    // y deserialization va en la otra clase ShowactivityPaciente
                    String jsonPaciente = gsonPaciente.toJson(paciente);
                    intent.putExtra("jsonPaciente", jsonPaciente);
                    startActivity(intent);
                }
            });
        }

        private void startActivity(Intent intent) {
        }
    }



    public void setData(List<Usuario> newList){
        pacientesList = newList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PacienteViewHolder(inflater.inflate(R.layout.listapacientes_item,viewGroup,false));
    }

    //rellenado de LOS CAMPOS DE LISTAPACIENTES_ITEM
    @Override
    public void onBindViewHolder(@NonNull PacienteViewHolder vh, int i) {
        Usuario paciente = pacientesList.get(i);
        vh.txtName.setText(paciente.getNombre());
        vh.txtSurname.setText(paciente.getApellidos());
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
