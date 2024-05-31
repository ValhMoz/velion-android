package com.sfr.clinic_app.inicio.interactor;

import com.sfr.clinic_app.api.Models.MedicalReport;
import java.util.ArrayList;

public interface InicioInteractor {

    void getReportsFromApi(InicioInteractor.OnGetProductsCallBacks callBacks, InicioInteractor.OnErrorServer errorServer);

    interface OnGetProductsCallBacks {
        void onSuccessCallBacks(ArrayList<MedicalReport> reports);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }


}
