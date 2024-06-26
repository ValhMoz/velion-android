package com.sfr.clinic_app.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.clinic_app.databinding.ActivityRegisterBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.presenter.LoginPresenter;
import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity implements LoginView{
    private ActivityRegisterBinding binding;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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
            startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            finish();
        } else {
            // Mostrar un mensaje de error al usuario o realizar alguna otra acción
            Toast.makeText(this, "Error: credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }

    public void onGoBack(View v){
        finish();
    }

    @Override
    public void onReedirigirALogin() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();

    }

    public void onRegister(View v) {
        presenter.register(
                binding.editTextName.getText().toString(),
                binding.editTextApellidos.getText().toString(),
                binding.editTextDNI.getText().toString(),
                binding.editTextFechaNacimiento.getText().toString(),
                //binding.editTextGenero.getText().toString(),
                binding.editTextDireccion.getText().toString(),
                binding.editTextProvincia.getText().toString(),
                binding.editTextMunicipio.getText().toString(),
                binding.editTextCP.getText().toString(),
                binding.editTextPhone.getText().toString(),
                binding.editTextEmail.getText().toString(),
                binding.editTextPass.getText().toString()
        );
    }
}

