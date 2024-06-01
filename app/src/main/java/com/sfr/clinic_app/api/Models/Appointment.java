package com.sfr.clinic_app.api.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appointment {

    @SerializedName("cita_id")
    @Expose
    private int id;

    @SerializedName("fecha_hora")
    @Expose
    private String date;

    @SerializedName("paciente_id")
    @Expose
    private int userId;

    @SerializedName("fisioterapeuta_id")
    @Expose
    private int doctorId;

    @SerializedName("descripcion")
    @Expose
    private String description;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
