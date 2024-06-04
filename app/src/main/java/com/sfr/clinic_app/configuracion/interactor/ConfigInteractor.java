package com.sfr.clinic_app.configuracion.interactor;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.api.Models.User;

import java.util.ArrayList;

public interface ConfigInteractor {

    void getUsersFromApi(ConfigInteractor.OnGetUsersCallBacks callBacks, ConfigInteractor.OnErrorServer errorServer);

    interface OnGetUsersCallBacks {
        void onSuccessCallBacks(ArrayList<User> user);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }


}
