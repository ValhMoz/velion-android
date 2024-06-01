package com.sfr.clinic_app.login.interactor;

import android.util.Log;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.api.wsApi.WsApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorImpl implements LoginInteractor {

    @Inject
    WsApi wsApi;
    @Inject
    public LoginInteractorImpl() {}

    @Override
    public void checkCredentials(String username, String password, LoginInteractor.OnGetLoginCallBacks callBacks, LoginInteractor.OnErrorServer errorServer) {
        wsApi.login(username, password).enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
//                    Log.i("info123", ""+response.body());
                    callBacks.onSuccessCallBacks(new ArrayList<User>(response.body()));
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                errorServer.errorServerMessage(t.getMessage());
            }
        });
    }
}
