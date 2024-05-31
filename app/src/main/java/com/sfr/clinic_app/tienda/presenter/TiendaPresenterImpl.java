package com.sfr.clinic_app.tienda.presenter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.tienda.interactor.TiendaInteractor;
import com.sfr.clinic_app.tienda.view.TiendaFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class TiendaPresenterImpl implements TiendaPresenter, TiendaInteractor.OnGetProductsCallBacks, TiendaInteractor.OnErrorServer {

    @Nullable
    @Inject
    TiendaFragment tiendaview;

    @Inject
    TiendaInteractor tiendainteractor;

    @Inject
    public TiendaPresenterImpl(){}

    @Override
    public void onArticlesFetched() {
        tiendainteractor.getArticlesFromApi(this, this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Product> products) {
        tiendaview.showProducts(products);
    }

    @Override
    public void onErrorCallBacks(int code) {
        //Log.e("respuesta erronea", ""+code);

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
