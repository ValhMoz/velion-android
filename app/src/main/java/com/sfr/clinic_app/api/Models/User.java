package com.sfr.clinic_app.api.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("usuario_id")
    @Expose
    private int id;

    @SerializedName("nombre")
    @Expose
    private String name;

    @SerializedName("apellidos")
    @Expose
    private String surname;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("fecha_nacimiento")
    @Expose
    private String birthdate;

    @SerializedName("direccion")
    @Expose
    private String address;

    @SerializedName("provincia")
    @Expose
    private String province;

    @SerializedName("municipio")
    @Expose
    private String city;

    @SerializedName("cp")
    @Expose
    private String postalCode;

    @SerializedName("telefono")
    @Expose
    private String phone;

    @SerializedName("genero")
    @Expose
    private String gender;

    @SerializedName("sesiones_disponibles")
    @Expose
    private String sesiones_disponibles;

    @SerializedName("pass")
    @Expose
    private String password;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSesiones_disponibles() {
        return sesiones_disponibles;
    }

    public void setSesiones_disponibles(String sesiones_disponibles) {
        this.sesiones_disponibles = sesiones_disponibles;
    }
}


