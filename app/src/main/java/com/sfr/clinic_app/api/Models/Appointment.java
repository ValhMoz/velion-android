package com.sfr.clinic_app.api.Models;

import com.google.gson.annotations.SerializedName;

public class Appointment {

    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private String date;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("doctor_id")
    private int doctorId;

    @SerializedName("description")
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
