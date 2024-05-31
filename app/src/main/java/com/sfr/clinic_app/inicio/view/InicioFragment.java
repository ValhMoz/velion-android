package com.sfr.clinic_app.inicio.view;

import com.sfr.clinic_app.api.Models.MedicalReport;

import java.util.ArrayList;

public interface InicioFragment {
    void showReports(ArrayList<MedicalReport> reports);

}
