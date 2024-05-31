package com.sfr.clinic_app.citas.interactor;

import com.sfr.clinic_app.api.Models.Appointment;
import java.util.ArrayList;

public interface CitasInteractor {

    void getAppointmentsFromApi(CitasInteractor.OnGetAppointmentsCallBacks callBacks, CitasInteractor.OnErrorServer errorServer);

    interface OnGetAppointmentsCallBacks {
        void onSuccessCallBacks(ArrayList<Appointment> appointments);
        void onErrorCallBacks(int code);
    }

    interface OnErrorServer {
        void errorServerMessage(String message);
    }


}
