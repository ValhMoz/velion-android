package com.sfr.clinic_app.login.presenter;

public interface LoginPresenter {
    void checkCredentials(String username, String password);
    void obtenerCredenciales();
    void register(String nombre, String apellidos, String usuario_id, String fecha_nacimiento, String direccion, String provincia, String municipio, String cp, String telefono, String email, String pass);
    void resetpass(String email);
}
