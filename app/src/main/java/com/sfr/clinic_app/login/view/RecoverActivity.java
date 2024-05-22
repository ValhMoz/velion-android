package com.sfr.clinic_app.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.sfr.clinic_app.databinding.ActivityRecoverBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.presenter.LoginPresenter;
import javax.inject.Inject;

public class RecoverActivity extends AppCompatActivity implements LoginView {
    private ActivityRecoverBinding binding;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecoverBinding.inflate(getLayoutInflater());
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
            startActivity(new Intent(RecoverActivity.this, HomeActivity.class));
            finish();
        } else {
            // Mostrar un mensaje de error al usuario o realizar alguna otra acción
            Toast.makeText(this, "Error: credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }

    public void onGoBack(View v){
        finish();
    }
}
