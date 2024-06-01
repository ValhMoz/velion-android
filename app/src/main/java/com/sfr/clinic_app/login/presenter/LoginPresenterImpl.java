package com.sfr.clinic_app.login.presenter;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.main.view.MainView;
import com.sfr.clinic_app.login.interactor.LoginInteractor;
import com.sfr.clinic_app.login.view.LoginView;

import java.util.ArrayList;

import javax.inject.Inject;
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnGetLoginCallBacks, LoginInteractor.OnErrorServer {
    @Nullable
    @Inject
    LoginView loginview;

    @Nullable
    @Inject
    MainView mainview;

    @Inject
    LoginInteractor interactor;

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    public LoginPresenterImpl() {}

    private String username;

    @Override
    public void checkCredentials(String username, String password) {
        this.username = username;
        if (!username.isEmpty() && !password.isEmpty()) {
            interactor.checkCredentials(username, password, this, this);
        } else {
            mainview.onReedirigiraLoginActivity();
        }
    }

    public void guardarDatosSesion(String username, String password) {
        sharedPreferences.edit().putString("username", username).apply();
        sharedPreferences.edit().putString("password", password).apply();
    }

    public void obtenerCredenciales() {
        // Obtener el nombre de usuario y contraseña (con valores por defecto vacíos)
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        checkCredentials(username, password);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<User> users) {
//        Log.i("info", ""+users);
//        if (user.getEmail() == username) {
            //guardarDatosSesion(user.getEmail(), user.getPassword());
            if (loginview != null){
                loginview.onLoginCheck("Loggeado correctamente", true);
            } else {
                mainview.onReedirigiraHomeActivity();
            }
//        } else {
//            loginview.onLoginCheck("Error al loggearse", false);
//        }

    }

    @Override
    public void onErrorCallBacks(int code) {
        if (loginview !=null) {
            loginview.onLoginCheck("Error al loggearse", false);
        }else{
            mainview.onReedirigiraLoginActivity();
        }
    }

    @Override
    public void errorServerMessage(String message) {

    }
}