package com.sfr.clinic_app.login.presenter;

public interface LoginPresenter {
    void checkCredentials(String username, String password);
    void obtenerCredenciales();
    void register(String nombre, String apellidos, String usuario_id, String telefono, String direccion, String provincia, String municipio, String cp, String email, String pass, String fecha_nacimiento, String rol);
    void resetpass(String email);
}
