package com.example.sintomedic;

import java.sql.Date;

public class Sintoma {

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getIdPaciente() {
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

    public Integer getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        Temperatura = temperatura;
    }

    public String getPresionArterial() {
        return PresionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        PresionArterial = presionArterial;
    }

    public String getPulso() {
        return Pulso;
    }

    public void setPulso(String pulso) {
        Pulso = pulso;
    }

    private String Descripcion;
    private Integer IdPaciente;
    private Integer  	IdDoctorEnviado;
    private java.sql.Date FechaHora ;
    private Integer  Temperatura ;
    private String  PresionArterial  ;
    private String  Pulso  ;

    public Sintoma(String descripcion, Integer idPaciente, Integer idDoctorEnviado, Date fechaHora, Integer temperatura, String presionArterial, String pulso) {
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
