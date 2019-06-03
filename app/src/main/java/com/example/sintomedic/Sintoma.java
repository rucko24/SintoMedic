package com.example.sintomedic;

import java.sql.Date;

public class Sintoma {

    private int id;
    private String Descripcion;
    private int IdPaciente;
    private java.sql.Date FechaHora ;
    private Float  Temperatura ;
    private Float  PresionArterial  ;
    private String  Pulso  ;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;    }



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

    public int getId() {
        return id;
    }



    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        IdPaciente = idPaciente;
    }

    public Sintoma(int id, int idPaciente) {
        this.id = id;
        IdPaciente = idPaciente;
    }

    public Sintoma(){
        super();
    }
}
