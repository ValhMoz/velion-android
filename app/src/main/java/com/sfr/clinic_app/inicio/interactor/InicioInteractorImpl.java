package com.sfr.clinic_app.inicio.interactor;

import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.wsApi.WsApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioInteractorImpl implements InicioInteractor{

    @Inject
    public InicioInteractorImpl() {}

    @Inject
    WsApi wsApi;
    @Override
    public void getReportsFromApi(InicioInteractor.OnGetProductsCallBacks callBack, InicioInteractor.OnErrorServer errorServer) {
        wsApi.getAllReports().enqueue(new Callback<List<MedicalReport>>() {

            @Override
            public void onResponse(Call<List<MedicalReport>> call, Response<List<MedicalReport>> response) {
                if(response.isSuccessful()){
                    callBack.onSuccessCallBacks(new ArrayList<MedicalReport>(response.body()));
                }else{
                    callBack.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MedicalReport>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}
