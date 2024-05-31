package com.sfr.clinic_app.api.Models;

import com.google.gson.annotations.SerializedName;

public class Speciality {

    @SerializedName("especialidad_id")
    private int id;

    @SerializedName("name")
    private String name;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
