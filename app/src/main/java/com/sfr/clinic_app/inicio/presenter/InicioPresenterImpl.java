package com.sfr.clinic_app.inicio.presenter;

import androidx.annotation.Nullable;
import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.inicio.interactor.InicioInteractor;
import com.sfr.clinic_app.inicio.view.InicioFragment;
import java.util.ArrayList;
import javax.inject.Inject;

public class InicioPresenterImpl implements InicioPresenter, InicioInteractor.OnGetProductsCallBacks, InicioInteractor.OnErrorServer {

    @Nullable
    @Inject
    InicioFragment inicioview;

    @Inject
    InicioInteractor inicioInteractor;

    @Inject
    public InicioPresenterImpl(){}


    @Override
    public void onReportsFetched() {
        inicioInteractor.getReportsFromApi(this, this);

    }

    @Override
    public void downloadAndSaveFile(int id) {
        inicioInteractor.downloadAndSaveFile(id);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<MedicalReport> reports) {
        inicioview.showReports(reports);
    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
