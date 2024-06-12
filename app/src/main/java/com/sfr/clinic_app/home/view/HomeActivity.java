package com.sfr.clinic_app.home.view;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationBarView;
import com.sfr.clinic_app.R;
import com.sfr.clinic_app.citas.view.CitasFragmentImpl;
import com.sfr.clinic_app.configuracion.view.ConfigFragmentImpl;
import com.sfr.clinic_app.databinding.ActivityHomeBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.inicio.view.InicioFragmentImpl;
import com.sfr.clinic_app.invoice.view.InvoiceFragmentImpl;
import com.sfr.clinic_app.tienda.view.TiendaFragmentImpl;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InicioFragmentImpl());
        binding.bottomNavigation.setOnItemSelectedListener(this);
        initInjection();
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container,fragment);
        fragmentTransaction.commit();
    }
    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int IdBotonPulsado = menuItem.getItemId();

        int[] optionMenu = new int[binding.bottomNavigation.getMenu().size()];
        for (int i=0; i<binding.bottomNavigation.getMenu().size(); i++) {
            optionMenu[i]=binding.bottomNavigation.getMenu().getItem(i).getItemId();
        }

        if(optionMenu[0]==IdBotonPulsado){
            replaceFragment(new InicioFragmentImpl());
        }

        if(optionMenu[1]==IdBotonPulsado) {
            replaceFragment(new CitasFragmentImpl());
        }

        if(optionMenu[2]==IdBotonPulsado) {
            replaceFragment(new InvoiceFragmentImpl());
        }

        if (optionMenu[3]==IdBotonPulsado) {
            replaceFragment(new TiendaFragmentImpl());
        }

        if (optionMenu[4]==IdBotonPulsado) {
            replaceFragment(new ConfigFragmentImpl());
        }

        return true;
    }
}