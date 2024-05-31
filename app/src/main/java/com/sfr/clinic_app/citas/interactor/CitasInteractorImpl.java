package com.sfr.clinic_app.citas.interactor;

import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.api.wsApi.WsApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitasInteractorImpl implements CitasInteractor{

    @Inject
    WsApi wsApi;

    @Inject
    public CitasInteractorImpl() {}

    @Override
    public void getAppointmentsFromApi(OnGetAppointmentsCallBacks callBacks, OnErrorServer errorServer) {
        wsApi.getAllAppoinments().enqueue(new Callback<List<Appointment>>() {

            @Override
            public void onResponse(Call<List<Appointment>> call, Response<List<Appointment>> response) {
                if(response.isSuccessful()){
                    callBacks.onSuccessCallBacks(new ArrayList<Appointment>(response.body()));
                }else{
                    callBacks.onErrorCallBacks(response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Appointment>> call, Throwable t) {
                errorServer.errorServerMessage(Arrays.toString(t.getStackTrace()));
            }
        });
    }
}
