package com.sfr.clinic_app.invoice.interactor;

import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.api.Models.Product;

import java.util.ArrayList;

public interface InvoiceInteractor {

    void getInvoicesFromApi(OnGetInvoicesCallBacks callBacks, OnErrorServer errorServer);

    interface OnGetInvoicesCallBacks {
        void onSuccessCallBacks(ArrayList<Invoice> invoices);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }
}
