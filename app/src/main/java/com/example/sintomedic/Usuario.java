package com.example.sintomedic;

import android.widget.ImageView;

import java.util.Date;

public class Usuario {
    private int id;
    private String Nombre;
    private String Apellidos;
    private String Contrasenia;
    private String CompaniaAseguradora;
    private String centro_medico;
    private String DNI_NIE;


    private String Localidad;
    private String  Telefono;
    private String  Correo ;
    private Date fechaNacimiento;
    private Integer   	Id_Enfermedad;
    private Integer   	id_lista_pacientes;
    private Integer   	id_lista_doctores;
    private Integer  id_lista_proximas_consultas;
    private Integer   	id_lista_sintomas;
    private Integer   	Num_colegiado ;
    private String Enfermedad;
    private String Tratamiento;
    private String 	link_foto_perfil;
    private ImageView fotoPaciente;
    private  boolean es_doctor;


    public Usuario(int  id, String contrasenia, String DNI_NIE) {
        this.id = id;
        Contrasenia = contrasenia;
        this.DNI_NIE = DNI_NIE;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public String getCompaniaAseguradora() {
        return CompaniaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        CompaniaAseguradora = companiaAseguradora;
    }

    public boolean isEs_doctor() {
        return es_doctor;
    }




    public String getCentro_medico() {
        return centro_medico;
    }

    public void setCentro_medico(String centro_medico) {
        this.centro_medico = centro_medico;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId_Enfermedad() {
        return Id_Enfermedad;
    }

    public void setId_Enfermedad(Integer id_Enfermedad) {
        Id_Enfermedad = id_Enfermedad;
    }

    public Integer getId_lista_pacientes() {
        return id_lista_pacientes;
    }

    public void setId_lista_pacientes(Integer id_lista_pacientes) {
        this.id_lista_pacientes = id_lista_pacientes;
    }

    public Integer getId_lista_doctores() {
        return id_lista_doctores;
    }

    public void setId_lista_doctores(Integer id_lista_doctores) {
        this.id_lista_doctores = id_lista_doctores;
    }

    public Integer getId_lista_proximas_consultas() {
        return id_lista_proximas_consultas;
    }

    public void setId_lista_proximas_consultas(Integer id_lista_proximas_consultas) {
        this.id_lista_proximas_consultas = id_lista_proximas_consultas;
    }

    public Integer getId_lista_sintomas() {
        return id_lista_sintomas;
    }

    public void setId_lista_sintomas(Integer id_lista_sintomas) {
        this.id_lista_sintomas = id_lista_sintomas;
    }

    public Integer getNum_colegiado() {
        return Num_colegiado;
    }

    public void setNum_colegiado(Integer num_colegiado) {
        Num_colegiado = num_colegiado;
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

    public String getLink_foto_perfil() {
        return link_foto_perfil;
    }

    public void setLink_foto_perfil(String link_foto_perfil) {
        this.link_foto_perfil = link_foto_perfil;
    }

    public ImageView getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(ImageView fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }

    public boolean isEs_doctor(boolean b) {
        return es_doctor;
    }

    public void setEs_doctor(boolean es_doctor) {
        this.es_doctor = es_doctor;
    }


}
