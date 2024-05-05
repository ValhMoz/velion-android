package com.sfr.clinic_app.login.presenter;

public interface LoginPresenter {
    void checkCredentials(String username, String password);
    void obtenerCredenciales();
}
