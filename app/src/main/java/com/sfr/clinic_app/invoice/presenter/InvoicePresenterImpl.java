package com.sfr.clinic_app.invoice.presenter;

import android.util.Log;

import androidx.annotation.Nullable;

import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.invoice.interactor.InvoiceInteractor;
import com.sfr.clinic_app.invoice.view.InvoiceFragment;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoicePresenterImpl implements InvoicePresenter, InvoiceInteractor.OnGetInvoicesCallBacks, InvoiceInteractor.OnErrorServer{
    @Nullable
    @Inject
    InvoiceFragment invoiceview;

    @Inject
    InvoiceInteractor invoiceinteractor;

    @Inject
    public InvoicePresenterImpl(){}

    @Override
    public void onInvoicesFetched() {
        invoiceinteractor.getInvoicesFromApi(this,this);

    }

    @Override
    public void onSuccessCallBacks(ArrayList<Invoice> invoices) {
        invoiceview.showInvoices(invoices);
    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
