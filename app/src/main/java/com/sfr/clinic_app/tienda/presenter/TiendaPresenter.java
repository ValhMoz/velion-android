package com.sfr.clinic_app.tienda.presenter;

import com.sfr.clinic_app.tienda.interactor.TiendaInteractor;

public interface TiendaPresenter {
    void onArticlesFetched();
    void purchase(String product_id, String paciente_id, String fecha_emision, String estado);


}
