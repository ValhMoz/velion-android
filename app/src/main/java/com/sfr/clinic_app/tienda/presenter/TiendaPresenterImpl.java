package com.sfr.clinic_app.tienda.presenter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.tienda.interactor.TiendaInteractor;
import com.sfr.clinic_app.tienda.view.CheckoutActivity;
import com.sfr.clinic_app.tienda.view.TiendaFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class TiendaPresenterImpl implements TiendaPresenter, TiendaInteractor.OnGetProductsCallBacks, TiendaInteractor.OnErrorServer, TiendaInteractor.OnGetPurchaseCallBacks {

    @Nullable
    @Inject
    TiendaFragment tiendaview;

    @Nullable
    @Inject
    CheckoutActivity checkoutActivity;


    @Inject
    TiendaInteractor tiendainteractor;

    @Inject
    public TiendaPresenterImpl(){}

    @Override
    public void onArticlesFetched() {
        tiendainteractor.getArticlesFromApi(this, this);
    }

    @Override
    public void purchase(String product_id, String paciente_id, String fecha_emision, String estado) {
        tiendainteractor.purchase(product_id, paciente_id, fecha_emision, estado, this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Product> products) {
        tiendaview.showProducts(products);
    }

    @Override
    public void onSuccessCallBacks(ResponseBody responseBody) {
        checkoutActivity.onGoToHome();
    }

    @Override
    public void onErrorCallBacks(int code) {
        Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}