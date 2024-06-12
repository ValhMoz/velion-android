package com.sfr.clinic_app.di.appModule;

import android.content.Context;
import androidx.annotation.Nullable;

import com.sfr.clinic_app.citas.interactor.CitasInteractor;
import com.sfr.clinic_app.citas.interactor.CitasInteractorImpl;
import com.sfr.clinic_app.citas.presenter.CitasPresenter;
import com.sfr.clinic_app.citas.presenter.CitasPresenterImpl;
import com.sfr.clinic_app.citas.view.CitasFragment;
import com.sfr.clinic_app.citas.view.CitasFragmentImpl;
import com.sfr.clinic_app.configuracion.interactor.ConfigInteractor;
import com.sfr.clinic_app.configuracion.interactor.ConfigInteractorImpl;
import com.sfr.clinic_app.configuracion.presenter.ConfigPresenter;
import com.sfr.clinic_app.configuracion.presenter.ConfigPresenterImpl;
import com.sfr.clinic_app.configuracion.view.ConfigFragment;
import com.sfr.clinic_app.configuracion.view.ConfigFragmentImpl;
import com.sfr.clinic_app.inicio.interactor.InicioInteractor;
import com.sfr.clinic_app.inicio.interactor.InicioInteractorImpl;
import com.sfr.clinic_app.inicio.presenter.InicioPresenter;
import com.sfr.clinic_app.inicio.presenter.InicioPresenterImpl;
import com.sfr.clinic_app.inicio.view.InicioFragment;
import com.sfr.clinic_app.invoice.interactor.InvoiceInteractor;
import com.sfr.clinic_app.invoice.interactor.InvoiceInteractorImpl;
import com.sfr.clinic_app.invoice.presenter.InvoicePresenter;
import com.sfr.clinic_app.invoice.presenter.InvoicePresenterImpl;
import com.sfr.clinic_app.invoice.view.InvoiceFragment;
import com.sfr.clinic_app.invoice.view.InvoiceFragmentImpl;
import com.sfr.clinic_app.login.view.RecoverActivity;
import com.sfr.clinic_app.login.view.RegisterActivity;
import com.sfr.clinic_app.main.view.MainActivity;
import com.sfr.clinic_app.main.view.MainView;
import com.sfr.clinic_app.login.interactor.LoginInteractorImpl;
import com.sfr.clinic_app.login.interactor.LoginInteractor;
import com.sfr.clinic_app.login.presenter.LoginPresenter;
import com.sfr.clinic_app.inicio.view.InicioFragmentImpl;
import com.sfr.clinic_app.login.view.LoginView;
import com.sfr.clinic_app.login.presenter.LoginPresenterImpl;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.login.view.LoginActivity;
import com.sfr.clinic_app.tienda.interactor.TiendaInteractor;
import com.sfr.clinic_app.tienda.interactor.TiendaInteractorImpl;
import com.sfr.clinic_app.tienda.presenter.TiendaPresenter;
import com.sfr.clinic_app.tienda.presenter.TiendaPresenterImpl;
import com.sfr.clinic_app.tienda.view.TiendaFragment;
import com.sfr.clinic_app.tienda.view.TiendaFragmentImpl;

import dagger.Module;
import dagger.Provides;

@Module(includes = {SharedPreferencesModule.class, ConnectionModule.class})
public class AppModule {
    private LoginActivity loginactivity;
    private RegisterActivity registerActivity;
    private RecoverActivity recoverActivity;
    private MainActivity mainactivity;
    private HomeActivity homeactivity;
    private InicioFragmentImpl inicioFragment;
    private CitasFragmentImpl citasFragment;
    private InvoiceFragmentImpl invoiceFragment;
    private TiendaFragmentImpl tiendaFragment;
    private ConfigFragmentImpl configFragment;
    private Context context;


    // Un constructor por cada vista
    public AppModule(){}

    public AppModule(MainActivity mainactivity, Context context) {
        this.mainactivity = mainactivity;
        this.context = context;

    }
    public AppModule(LoginActivity loginactivity, Context context) {
        this.loginactivity = loginactivity;
        this.context = context;

    }

    public AppModule(RecoverActivity recoverActivity, Context context) {
        this.recoverActivity = recoverActivity;
        this.context = context;

    }

    public AppModule(RegisterActivity registerActivity, Context context) {
        this.registerActivity = registerActivity;
        this.context = context;

    }

    public AppModule(HomeActivity homeactivity, Context context) {
        this.homeactivity = homeactivity;
        this.context = context;

    }

    public AppModule(InicioFragmentImpl inicioFragment, Context context) {
        this.inicioFragment = inicioFragment;
        this.context = context;

    }

    public AppModule(CitasFragmentImpl citasFragment, Context context) {
        this.citasFragment = citasFragment;
        this.context = context;

    }

    public AppModule(InvoiceFragmentImpl invoiceFragment, Context context) {
        this.invoiceFragment = invoiceFragment;
        this.context = context;

    }

    public AppModule(TiendaFragmentImpl tiendaFragment, Context context) {
        this.tiendaFragment = tiendaFragment;
        this.context = context;

    }

    public AppModule(ConfigFragmentImpl configFragment, Context context) {
        this.configFragment = configFragment;
        this.context = context;

    }


    // Un método de estos por cada vista
    @Nullable
    @Provides
    public LoginView loginactivity() {
        if(loginactivity != null){
            return loginactivity;
        }
        return null;
    }

    @Nullable
    @Provides
    public RegisterActivity registerActivity() {
        if(recoverActivity!=null){
            return registerActivity;

        }
        return null;
    }

    @Nullable
    @Provides
    public RecoverActivity recoverActivity() {
        if(recoverActivity!=null){
            return recoverActivity;

        }
        return null;
    }

    @Nullable
    @Provides
    public MainView mainactivity() {
        if(mainactivity != null){
            return mainactivity;
        }
        return null;
    }


    @Nullable
    @Provides
    public InicioFragment iniciofragment() {
        if(inicioFragment!=null){
            return inicioFragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public CitasFragment citasFragment() {
        if(citasFragment!=null){
            return citasFragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public InvoiceFragment invoiceFragment() {
        if(invoiceFragment!=null){
            return invoiceFragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public TiendaFragment tiendaFragment() {
        if(tiendaFragment!=null){
            return tiendaFragment;

        }
        return null;
    }

    @Nullable
    @Provides
    public ConfigFragment configFragment() {
        if(configFragment!=null){
            return configFragment;

        }
        return null;
    }



    @Provides
    public LoginPresenter providesLoginPresenterImpl(LoginPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public TiendaPresenter providesTiendaPresenterImpl(TiendaPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public CitasPresenter providesCitasPresenterImpl(CitasPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public InvoicePresenter providesInvoicePresenterImpl(InvoicePresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public ConfigPresenter providesConfigPresenterImpl(ConfigPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public InicioPresenter providesInicioPresenterImpl(InicioPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    public LoginInteractor providesLoginInteractorImpl(LoginInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public InicioInteractor providesInicioInteractorImpl(InicioInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public CitasInteractor providesCitasnteractorImpl(CitasInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public InvoiceInteractor providesInvoicenteractorImpl(InvoiceInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public TiendaInteractor providesTiendaInteractorImpl(TiendaInteractorImpl interactor) {
        return interactor;
    }
    @Provides
    public ConfigInteractor providesConfigInteractorImpl(ConfigInteractorImpl interactor) {
        return interactor;
    }



}
