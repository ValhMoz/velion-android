package com.sfr.clinic_app.main.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.sfr.clinic_app.databinding.ActivityMainBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.login.presenter.LoginPresenter;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.view.LoginActivity;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {
    private ActivityMainBinding binding;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();
        presenter.obtenerCredenciales();
    }

    private void initInjection() {
       AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }


    @Override
    public void onReedirigiraLoginActivity() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onReedirigiraHomeActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();
    }

}