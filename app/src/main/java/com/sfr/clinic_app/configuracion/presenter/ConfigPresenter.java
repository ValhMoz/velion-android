package com.sfr.clinic_app.configuracion.presenter;

public interface ConfigPresenter {
    void onUsersFetched();
    void onUpdateUserData(String newEmail, String newPass);

}
