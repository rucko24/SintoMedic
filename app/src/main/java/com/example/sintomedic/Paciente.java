package com.example.sintomedic;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Paciente {

    private Long id;
    private String Nombre;
    private String Apellidos;
    private String CompaniaAseguradora;
    private String DNI_NIE;
    private String Localidad;
    private String  Telefono ;
    private String  Correo ;



    private ImageView fotoPaciente;

    public Paciente(){
        super();
    }
    public Paciente(Long id, String nombre) {
        super();
        Nombre = nombre;
        id=id;
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
