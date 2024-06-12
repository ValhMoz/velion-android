package com.sfr.clinic_app.configuracion.interactor;

import android.content.SharedPreferences;
import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.api.wsApi.WsApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigInteractorImpl implements ConfigInteractor{

    @Inject
    WsApi wsApi;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public ConfigInteractorImpl() {}

    @Override
    public void getUsersFromApi(OnGetUsersCallBacks callBacks, OnErrorServer errorServer) {
        String userid = sharedPreferences.getString("usuario_id", null);

        wsApi.getUserByUserId(userid).enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    callBacks.onSuccessCallBacks(new ArrayList<User>(response.body()));
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }

    @Override
    public void onUpdateUserData(String newEmail, String newPass, OnGetUpdatedUserDataCallBacks callBacks, OnErrorServer errorServer) {
        String userid = sharedPreferences.getString("usuario_id", null);

        wsApi.updateUserData(userid, newEmail, newPass).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    callBacks.onSuccessCallBacks(response.body());
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}
