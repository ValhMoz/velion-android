package com.sfr.clinic_app.tienda.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.ActivityCheckoutBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.home.view.HomeActivity;
import com.sfr.clinic_app.tienda.presenter.TiendaPresenter;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

public class CheckoutActivity extends AppCompatActivity implements TiendaFragment{
    private ActivityCheckoutBinding binding;
    private Product product;
    @Inject
    TiendaPresenter presenter;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initInjection();

        product = getIntent().getParcelableExtra("product");

        showData(product);

        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchase(v);
            }
        });

        binding.btnOnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoBack(v);
            }
        });
    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, this))
                .sharedPreferencesModule(new SharedPreferencesModule(this))
                .build();
        appComponent.inject(this);
    }

    @Override
    public void showProducts(ArrayList<Product> products) {

    }

    private void showData(Product product){
        binding.tvProductDescription.setText(product.getDescripcion());
        binding.tvProductName.setText(product.getNombre());
        binding.tvProductPrice.setText(product.getMonto());
    }

    @Override
    public void onGoToHome() {
        startActivity(new Intent(this, TiendaFragmentImpl.class));

    }

    private void purchase (View v){
        Date fecha = new Date();
        presenter.purchase(product.getProductoid(), sharedPreferences.getString("usuario_id", null) , String.valueOf(fecha.getDate()),"Pagada");
    }

    public void onGoBack(View v){
        finish();
    }

}
