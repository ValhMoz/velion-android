package com.sfr.clinic_app.login.interactor;

import com.sfr.clinic_app.api.Models.User;

import java.util.ArrayList;

public interface LoginInteractor {
    void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks, LoginInteractor.OnErrorServer errorServer);


    interface OnGetLoginCallBacks {
        void onSuccessCallBacks(ArrayList<User> users);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
