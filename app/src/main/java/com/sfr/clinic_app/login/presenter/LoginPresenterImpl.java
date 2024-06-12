package com.sfr.clinic_app.login.presenter;

import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.login.view.RecoverActivity;
import com.sfr.clinic_app.login.view.RegisterActivity;
import com.sfr.clinic_app.main.view.MainView;
import com.sfr.clinic_app.login.interactor.LoginInteractor;
import com.sfr.clinic_app.login.view.LoginView;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnGetLoginCallBacks, LoginInteractor.OnErrorServer, LoginInteractor.OnGetRegisterCallBacks, LoginInteractor.OnGetRecoverPassCallBacks {
    @Nullable
    @Inject
    LoginView loginview;

    @Nullable
    @Inject
    RegisterActivity registerActivity;

    @Nullable
    @Inject
    RecoverActivity recoverActivity;

    @Nullable
    @Inject
    MainView mainview;

    @Inject
    LoginInteractor interactor;

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    public LoginPresenterImpl() {}

    @Override
    public void checkCredentials(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            interactor.checkCredentials(username, password, this, this);
        } else if (loginview != null) {
            loginview.onLoginCheck("Por favor, complete todos los campos", false);
        } else {
            mainview.onReedirigiraLoginActivity();

        }
    }

    public void guardarDatosSesion(String username, String password, String id) {
        sharedPreferences.edit().putString("username", username).apply();
        sharedPreferences.edit().putString("password", password).apply();
        sharedPreferences.edit().putString("usuario_id", id).apply();

    }

    public void obtenerCredenciales() {
        // Obtener el nombre de usuario y contraseña (con valores por defecto vacíos)
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        checkCredentials(username, password);
    }

    @Override
    public void register(String nombre, String apellidos, String usuario_id, String fecha_nacimiento, String direccion, String provincia, String municipio, String cp, String telefono, String email, String pass) {
        interactor.register(nombre, apellidos, usuario_id, fecha_nacimiento, direccion, provincia, municipio, cp, telefono, email, pass, this, this);
    }

    @Override
    public void resetpass(String email) {
        interactor.resetpass(email, this, this);
    }

    @Override
    public void onSuccessCallBacks(User user, String password) {
        if (user.getMessage() == null ) {
            guardarDatosSesion(user.getEmail(), password, user.getId());
            if (loginview != null){
                loginview.onLoginCheck("Loggeado correctamente", true);
            } else {
                 mainview.onReedirigiraHomeActivity();
            }
        } else if (loginview != null) {
            loginview.onLoginCheck("Credenciales incorrectas", false);
        } else {
            mainview.onReedirigiraLoginActivity();
        }

    }

    @Override
    public void onSuccessCallBacks(ResponseBody responseBody) {
        if (registerActivity != null) {
            registerActivity.onReedirigirALogin();

        }else if(recoverActivity!=null){
            recoverActivity.onReedirigirALogin();
        }

    }

    @Override
    public void onErrorCallBacks(int code) {
        if (loginview !=null) {
            loginview.onLoginCheck("Error "+code, false);
        }else if (mainview!=null){
            mainview.onReedirigiraLoginActivity();
        }else{
            recoverActivity.onReedirigirALogin();
        }
    }

    @Override
    public void errorServerMessage(String message) {
        if (loginview !=null) {
            loginview.onLoginCheck(message, false);
        } else if (mainview!=null){
            mainview.onReedirigiraLoginActivity();
        }else{
            recoverActivity.onReedirigirALogin();
        }

    }
}