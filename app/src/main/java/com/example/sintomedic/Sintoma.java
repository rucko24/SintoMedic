package com.example.sintomedic;

import java.sql.Date;

public class Sintoma {

    private String Descripcion;
    private Integer IdPaciente;
    private Integer  	IdDoctorEnviado;
    private java.sql.Date FechaHora ;
    private Float  Temperatura ;
    private Float  PresionArterial  ;
    private String  Pulso  ;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        IdPaciente = idPaciente;
    }

    public Integer getIdDoctorEnviado() {
        return IdDoctorEnviado;
    }

    public void setIdDoctorEnviado(Integer idDoctorEnviado) {
        IdDoctorEnviado = idDoctorEnviado;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        FechaHora = fechaHora;
    }

    public Float getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(Float temperatura) {
        Temperatura = temperatura;
    }

    public Float getPresionArterial() {
        return PresionArterial;
    }

    public void setPresionArterial(Float presionArterial) {
        PresionArterial = presionArterial;
    }

    public String getPulso() {
        return Pulso;
    }

    public void setPulso(String pulso) {
        Pulso = pulso;
    }



    public Sintoma(String descripcion, Integer idPaciente, Integer idDoctorEnviado, Date fechaHora, Float temperatura, Float presionArterial, String pulso) {
        Descripcion = descripcion;
        IdPaciente = idPaciente;
        IdDoctorEnviado = idDoctorEnviado;
        FechaHora = fechaHora;
        Temperatura = temperatura;
        PresionArterial = presionArterial;
        Pulso = pulso;
    }

    public Sintoma(){
        super();
    }
}
