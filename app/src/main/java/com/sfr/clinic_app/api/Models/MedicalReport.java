package com.sfr.clinic_app.api.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicalReport {

    @SerializedName("historial_id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("historial_fecha")
    @Expose
    private String date;

    @SerializedName("historial_description")
    @Expose
    private String description;

    @SerializedName("historial_diagnostico")
    @Expose
    private String diagnostico;

    @SerializedName("historial_tratamiento")
    @Expose
    private String tratamiento;

    @SerializedName("historial_notas")
    @Expose
    private String notas;

    @SerializedName("especialidad")
    @Expose
    private String especialidad;

    @SerializedName("paciente_id")
    @Expose
    private int userId;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
