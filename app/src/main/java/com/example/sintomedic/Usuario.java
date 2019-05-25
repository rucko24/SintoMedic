package com.example.sintomedic;

import android.widget.ImageView;

import java.util.Date;

public class Usuario {
    private Long id;
    private String Nombre;
    private String Apellidos;
    private String Contrasenia;
    private String Companya_Aseguradora;
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
    private  boolean es_paciente;

    public Usuario(Long id, String nombre, String apellidos, String contrasenia, String companya_Aseguradora, String DNI_NIE, String localidad, String telefono, String correo, Date fechaNacimiento, Integer id_Enfermedad, Integer id_lista_pacientes, Integer id_lista_doctores, Integer id_lista_proximas_consultas, Integer id_lista_sintomas, Integer num_colegiado, String enfermedad, String tratamiento, String link_foto_perfil, ImageView fotoPaciente, boolean es_doctor, boolean es_paciente) {
        this.id = id;
        Nombre = nombre;
        Apellidos = apellidos;
        Contrasenia = contrasenia;
        Companya_Aseguradora = companya_Aseguradora;
        this.DNI_NIE = DNI_NIE;
        Localidad = localidad;
        Telefono = telefono;
        Correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        Id_Enfermedad = id_Enfermedad;
        this.id_lista_pacientes = id_lista_pacientes;
        this.id_lista_doctores = id_lista_doctores;
        this.id_lista_proximas_consultas = id_lista_proximas_consultas;
        this.id_lista_sintomas = id_lista_sintomas;
        Num_colegiado = num_colegiado;
        Enfermedad = enfermedad;
        Tratamiento = tratamiento;
        this.link_foto_perfil = link_foto_perfil;
        this.fotoPaciente = fotoPaciente;
        this.es_doctor = es_doctor;
        this.es_paciente = es_paciente;
    }

    public Usuario() {
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

    public String getCompanya_Aseguradora() {
        return Companya_Aseguradora;
    }

    public void setCompanya_Aseguradora(String companya_Aseguradora) {
        Companya_Aseguradora = companya_Aseguradora;
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

    public boolean isEs_doctor() {
        return es_doctor;
    }

    public void setEs_doctor(boolean es_doctor) {
        this.es_doctor = es_doctor;
    }

    public boolean isEs_paciente() {
        return es_paciente;
    }

    public void setEs_paciente(boolean es_paciente) {
        this.es_paciente = es_paciente;
    }
}
