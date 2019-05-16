package com.example.sintomedic;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PacienteSinParcelable {

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

    public PacienteSinParcelable(){
        super();
    }
    public PacienteSinParcelable(Long id, String nombre) {
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
}