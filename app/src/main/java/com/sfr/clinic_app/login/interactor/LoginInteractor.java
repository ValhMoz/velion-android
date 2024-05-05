package com.sfr.clinic_app.login.interactor;

public interface LoginInteractor {
    void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks);

    interface OnGetLoginCallBacks {
        void onSuccessCredentials(String username, String password);
        void onErrorCredentials();
    }
}
