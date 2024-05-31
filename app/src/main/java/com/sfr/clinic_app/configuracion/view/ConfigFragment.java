package com.sfr.clinic_app.configuracion.view;

import com.sfr.clinic_app.api.Models.User;

import java.util.ArrayList;

public interface ConfigFragment {
    void showUsers(ArrayList<User> users);
}
