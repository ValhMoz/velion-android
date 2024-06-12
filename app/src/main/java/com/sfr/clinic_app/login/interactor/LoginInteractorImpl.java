package com.sfr.clinic_app.login.interactor;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.api.wsApi.WsApi;
import javax.inject.Inject;

import okhttp3.ResponseBody;
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
        wsApi.login(username, password).enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    callBacks.onSuccessCallBacks(response.body(), password);
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                errorServer.errorServerMessage(t.getMessage());
            }
        });
    }

    @Override
    public void register(String nombre, String apellidos, String usuario_id, String fecha_nacimiento, String direccion, String provincia, String municipio, String cp, String telefono, String email, String pass, OnGetRegisterCallBacks callBacks, OnErrorServer errorServer ) {
        wsApi.register(nombre, apellidos, usuario_id, fecha_nacimiento, direccion, provincia, municipio, cp, telefono, email, pass).enqueue(new Callback<ResponseBody>() {

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
                errorServer.errorServerMessage(t.getMessage());

            }
        });
    }

    @Override
    public void resetpass(String email, OnGetRecoverPassCallBacks callBacks, OnErrorServer errorServer) {
        wsApi.resetPass(email).enqueue(new Callback<ResponseBody>() {
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
                errorServer.errorServerMessage(t.getMessage());

            }
        });

    }
}
