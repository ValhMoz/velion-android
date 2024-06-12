package com.sfr.clinic_app.invoice.interactor;

import android.content.SharedPreferences;

import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.api.wsApi.WsApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvoiceInteractorImpl implements InvoiceInteractor {

    @Inject
    WsApi wsApi;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    public InvoiceInteractorImpl() {}

    @Override
    public void getInvoicesFromApi(OnGetInvoicesCallBacks callBack, OnErrorServer errorServer) {
        String userId = sharedPreferences.getString("usuario_id", null);
        wsApi.getAllInvoicesByUserId(userId).enqueue(new Callback<List<Invoice>>() {

            @Override
            public void onResponse(Call<List<Invoice>> call, Response<List<Invoice>> response) {
                if(response.isSuccessful()){
                    callBack.onSuccessCallBacks(new ArrayList<Invoice>(response.body()));
                }else{
                    callBack.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Invoice>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}
