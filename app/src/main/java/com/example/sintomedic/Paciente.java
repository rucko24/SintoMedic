package com.example.sintomedic;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Paciente implements Parcelable {

    private Long id;
    private String Nombre;
    private String Apellidos;
    private String CompaniaAseguradora;
    private String DNI_NIE;
    private String Localidad;
    private String  Telefono ;
    private String  Correo ;
    private Date fechaNacimiento;
    private Date fecha_consulta_proxima;
    private String Enfermedad;
    private String Tratamiento;
    private ImageView fotoPaciente;

    public Paciente(){
        super();
    }
    public Paciente(Long id, String nombre) {
        super();
        Nombre = nombre;
        id=id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Date getFecha_consulta_proxima() {
        return fecha_consulta_proxima;
    }

    public void setFecha_consulta_proxima(Date fecha_consulta_proxima) {
        this.fecha_consulta_proxima = fecha_consulta_proxima;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        Enfermedad = enfermedad;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }


    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public ImageView getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(ImageView fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCompaniaAseguradora() {
        return CompaniaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        CompaniaAseguradora = companiaAseguradora;
    }

    public String getDNI_NIE() {
        return DNI_NIE;
    }

    public void setDNI_NIE(String DNI_NIE) {
        this.DNI_NIE = DNI_NIE;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    protected Paciente(Parcel in) {
        id = in.readByte() == 0x00 ? null : in.readLong();
        Nombre = in.readString();
        Apellidos = in.readString();
        CompaniaAseguradora = in.readString();
        DNI_NIE = in.readString();
        Localidad = in.readString();
        Telefono = in.readString();
        Correo = in.readString();
        long tmpFechaNacimiento = in.readLong();
        fechaNacimiento = tmpFechaNacimiento != -1 ? new Date(tmpFechaNacimiento) : null;
        long tmpFecha_consulta_proxima = in.readLong();
        fecha_consulta_proxima = tmpFecha_consulta_proxima != -1 ? new Date(tmpFecha_consulta_proxima) : null;
        Enfermedad = in.readString();
        Tratamiento = in.readString();
        fotoPaciente = (ImageView) in.readValue(ImageView.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(id);
        }
        dest.writeString(Nombre);
        dest.writeString(Apellidos);
        dest.writeString(CompaniaAseguradora);
        dest.writeString(DNI_NIE);
        dest.writeString(Localidad);
        dest.writeString(Telefono);
        dest.writeString(Correo);
        dest.writeLong(fechaNacimiento != null ? fechaNacimiento.getTime() : -1L);
        dest.writeLong(fecha_consulta_proxima != null ? fecha_consulta_proxima.getTime() : -1L);
        dest.writeString(Enfermedad);
        dest.writeString(Tratamiento);
        dest.writeValue(fotoPaciente);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Paciente> CREATOR = new Parcelable.Creator<Paciente>() {
        @Override
        public Paciente createFromParcel(Parcel in) {
            return new Paciente(in);
        }

        @Override
        public Paciente[] newArray(int size) {
            return new Paciente[size];
        }
    };
}