package com.sfr.clinic_app.login.interactor;

import com.sfr.clinic_app.api.Models.User;

import okhttp3.ResponseBody;

public interface LoginInteractor {
    void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks, LoginInteractor.OnErrorServer errorServer);
    void register(String nombre, String apellidos, String usuario_id, String telefono, String direccion, String provincia, String municipio, String cp, String email, String pass, String fecha_nacimiento, String rol, OnGetRegisterCallBacks callBacks, OnErrorServer errorServer);
    void resetpass(String email, OnGetRecoverPassCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetLoginCallBacks {
        void onSuccessCallBacks(User user, String password);
        void onErrorCallBacks(int code);
    }

    interface OnGetRegisterCallBacks {
        void onSuccessCallBacks(ResponseBody responseBody);
        void onErrorCallBacks(int code);
    }

    interface OnGetRecoverPassCallBacks {
        void onSuccessCallBacks(ResponseBody responseBody);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
