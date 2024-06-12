package com.sfr.clinic_app.configuracion.presenter;

import android.util.Log;
import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.configuracion.interactor.ConfigInteractor;
import com.sfr.clinic_app.configuracion.view.ConfigFragment;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import javax.inject.Inject;
import okhttp3.ResponseBody;

public class ConfigPresenterImpl implements ConfigPresenter, ConfigInteractor.OnGetUsersCallBacks, ConfigInteractor.OnGetUpdatedUserDataCallBacks, ConfigInteractor.OnErrorServer {

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
    public void onSuccessCallBacks(ResponseBody user) {
        configFragment.showUserUpdatedDataMessage();
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

    @Override
    public void onUpdateUserData(String newEmail, String newPass) {
        configInteractor.onUpdateUserData(newEmail, newPass, this, this);
    }
}
