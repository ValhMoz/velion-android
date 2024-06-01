package com.sfr.clinic_app.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.clinic_app.databinding.ActivityLoginBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.presenter.LoginPresenter;
import java.util.Objects;
import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private ActivityLoginBinding binding;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.i("info2", "entrando en loginpage");
        initInjection();
    }
    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }
    @Override
    public void onLoginCheck(String mensaje, boolean IsLoggedIn) {
        if (IsLoggedIn) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        } else {
            // Mostrar un mensaje de error al usuario o realizar alguna otra acción
            Toast.makeText(this, "Error: credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }

    public void onGoRegisterActivity(View v){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void onGoRecoverActivity(View v){
        startActivity(new Intent(this, RecoverActivity.class));
    }

    public void functioniniciar(View v){
        startActivity(new Intent(this, HomeActivity.class));
//        String username = Objects.requireNonNull(binding.editTextUsername.getText()).toString();
//        String password = Objects.requireNonNull(binding.editTextPassword.getText()).toString();
//        presenter.checkCredentials(username, password);

    }
}