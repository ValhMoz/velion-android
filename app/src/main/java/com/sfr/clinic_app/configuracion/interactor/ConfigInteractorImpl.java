package com.sfr.clinic_app.configuracion.interactor;

import android.util.Log;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.api.wsApi.WsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigInteractorImpl implements ConfigInteractor{

    @Inject
    WsApi wsApi;

    @Inject
    public ConfigInteractorImpl() {}

    @Override
    public void getUsersFromApi(OnGetUsersCallBacks callBacks, OnErrorServer errorServer) {
        wsApi.getAllUsers().enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Log.i("config", "");
                    callBacks.onSuccessCallBacks(response.body());
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}
