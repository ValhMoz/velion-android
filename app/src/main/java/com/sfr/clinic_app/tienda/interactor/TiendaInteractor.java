package com.sfr.clinic_app.tienda.interactor;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.invoice.interactor.InvoiceInteractor;

import java.util.ArrayList;

import okhttp3.ResponseBody;

public interface TiendaInteractor {

    void getArticlesFromApi(OnGetProductsCallBacks callBacks, OnErrorServer errorServer);
    void purchase(String product_id, String paciente_id, String fecha_emision, String estado, OnGetPurchaseCallBacks onGetPurchaseCallBacks, OnErrorServer onErrorServer);
    interface OnGetProductsCallBacks {
        void onSuccessCallBacks(ArrayList<Product> products);
        void onErrorCallBacks(int code);
    }

    interface OnGetPurchaseCallBacks {
        void onSuccessCallBacks(ResponseBody responseBody);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
