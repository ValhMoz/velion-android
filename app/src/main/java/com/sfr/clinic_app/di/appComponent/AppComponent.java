package com.sfr.clinic_app.di.appComponent;

import com.sfr.clinic_app.citas.view.CitasFragmentImpl;
import com.sfr.clinic_app.configuracion.view.ConfigFragmentImpl;
import com.sfr.clinic_app.inicio.view.InicioFragmentImpl;
import com.sfr.clinic_app.invoice.view.InvoiceFragmentImpl;
import com.sfr.clinic_app.login.view.RecoverActivity;
import com.sfr.clinic_app.login.view.RegisterActivity;
import com.sfr.clinic_app.main.view.MainActivity;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.view.LoginActivity;
import com.sfr.clinic_app.tienda.view.CheckoutActivity;
import com.sfr.clinic_app.tienda.view.TiendaFragmentImpl;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    void inject(MainActivity mainactivity);
    void inject(LoginActivity loginactivity);
    void inject(HomeActivity homeactivity);
    void inject(RegisterActivity registerActivity);
    void inject (RecoverActivity recoverActivity);
    void inject (InicioFragmentImpl inicioFragment);
    void inject (CitasFragmentImpl citasFragment);
    void inject(TiendaFragmentImpl tiendaFragment);
    void inject(ConfigFragmentImpl configFragment);
    void inject(InvoiceFragmentImpl invoiceFragment);
    void inject(CheckoutActivity checkoutActivity);

}