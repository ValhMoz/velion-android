package com.sfr.clinic_app.configuracion.presenter;

import android.util.Log;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.configuracion.interactor.ConfigInteractor;
import com.sfr.clinic_app.configuracion.view.ConfigFragment;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;

public class ConfigPresenterImpl implements ConfigPresenter, ConfigInteractor.OnGetUsersCallBacks, ConfigInteractor.OnErrorServer {

    @Nullable
    @Inject
    ConfigFragment configFragment;

    @Inject
    ConfigInteractor configInteractor;

    @Inject
    public ConfigPresenterImpl(){}


    @Override
    public void onSuccessCallBacks(ArrayList<User> user) {
        configFragment.showUsers(user);

    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }

    @Override
    public void onUsersFetched() {
        configInteractor.getUsersFromApi(this, this);

    }
}
