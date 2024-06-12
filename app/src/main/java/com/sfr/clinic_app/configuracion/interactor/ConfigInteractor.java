package com.sfr.clinic_app.configuracion.interactor;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.api.Models.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;

public interface ConfigInteractor {

    void getUsersFromApi(ConfigInteractor.OnGetUsersCallBacks callBacks, ConfigInteractor.OnErrorServer errorServer);
    void onUpdateUserData(String newEmail, String newPass, OnGetUpdatedUserDataCallBacks callBacks, OnErrorServer errorServer);
    interface OnGetUsersCallBacks {
        void onSuccessCallBacks(ArrayList<User> user);
        void onErrorCallBacks(int code);
    }

    interface OnGetUpdatedUserDataCallBacks {
        void onSuccessCallBacks(ResponseBody user);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }


}
