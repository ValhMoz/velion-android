package com.sfr.clinic_app.citas.presenter;

import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.citas.interactor.CitasInteractor;
import com.sfr.clinic_app.citas.view.CitasFragment;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import javax.inject.Inject;

public class CitasPresenterImpl implements CitasPresenter, CitasInteractor.OnGetAppointmentsCallBacks, CitasInteractor.OnErrorServer {

    @Nullable
    @Inject
    CitasFragment citasFragment;

    @Inject
    CitasInteractor citasInteractor;

    @Inject
    public CitasPresenterImpl(){}


    @Override
    public void onAppointmentsFetched() {
        citasInteractor.getAppointmentsFromApi(this,this);
    }

    @Override
    public void onSuccessCallBacks(ArrayList<Appointment> appointments) {
        citasFragment.showAppointments(appointments);
    }

    @Override
    public void onErrorCallBacks(int code) {

    }

    @Override
    public void errorServerMessage(String message) {

    }
}
