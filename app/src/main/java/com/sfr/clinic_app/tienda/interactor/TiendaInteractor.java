package com.sfr.clinic_app.tienda.interactor;

import com.sfr.clinic_app.api.Models.Product;

import java.util.ArrayList;

public interface TiendaInteractor {

    void getArticlesFromApi(OnGetProductsCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetProductsCallBacks {
        void onSuccessCallBacks(ArrayList<Product> products);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
