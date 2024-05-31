package com.sfr.clinic_app.citas.view;


import com.sfr.clinic_app.api.Models.Appointment;
import java.util.ArrayList;

public interface CitasFragment {
    void showAppointments(ArrayList<Appointment> appointments);

}
