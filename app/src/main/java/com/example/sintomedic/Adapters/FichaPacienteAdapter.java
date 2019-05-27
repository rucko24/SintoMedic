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

import com.example.sintomedic.AsignarConsultaPacienteActivity;
import com.example.sintomedic.GlideApp;
import com.example.sintomedic.R;
import com.example.sintomedic.ShowFichaPacienteActivity;
import com.example.sintomedic.ShowSintomasPacienteActivity;
import com.example.sintomedic.Usuario;
import com.google.gson.Gson;

import java.util.List;

public class FichaPacienteAdapter extends RecyclerView.Adapter<FichaPacienteAdapter.FichaPacienteViewHolder> {


    // lista de todos pacientes de X doctor
    Usuario paciente;
    LayoutInflater inflater;
    Context context;
    Gson gsonPaciente = new Gson();



    public FichaPacienteAdapter(Context context, Usuario paciente){
        this.paciente = paciente;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }



    public class FichaPacienteViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView txtName;
        TextView txtSurname;
        TextView fechaNacimiento;
        Button botonVerSintomas;
        Button proxConsulta;



        public FichaPacienteViewHolder(View view){
            super(view);
            imgThumbnail = view.findViewById(R.id.imagen_ficha_paciente);
            txtName = view.findViewById(R.id.nombre_ficha_paciente);
            txtSurname = view.findViewById(R.id.apellido_ficha_paciente);
            fechaNacimiento=view.findViewById(R.id.nacimiento_fecha_paciente);
            proxConsulta=view.findViewById(R.id.button_prox_consulta);

            /*Al apretar en Ver detalle sedl recycler view que abra otra activity*/
            botonVerSintomas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, AsignarConsultaPacienteActivity.class);

                    String jsonPaciente = gsonPaciente.toJson(paciente);
                    intent.putExtra("jsonPaciente", jsonPaciente);
                    startActivity(intent);
                }
            });
        }

        private void startActivity(Intent intent) {
        }
    }



    public void setData(Usuario newList){
        paciente = newList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public FichaPacienteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FichaPacienteAdapter.FichaPacienteViewHolder(inflater.inflate(R.layout.listasintomas_item,viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull FichaPacienteAdapter.FichaPacienteViewHolder fichaPacienteViewHolder, int i) {

    }


    //rellenado de LOS CAMPOS DE LISTAPACIENTES_ITEM
    @Override
    public void onBindViewHolder(@NonNull FichaPacienteAdapter.FichaPacienteViewHolder vh, int i) {
        Usuario paciente =  paciente.get(i);
        vh.txtName.setText(paciente.getNombre());
        vh.txtSurname.setText(paciente.getApellidos());
        GlideApp.with(context)
                .load(paciente.getFotoPaciente())
                .into(vh.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        if(paciente==null){
            return 0;
        }

    }
}
