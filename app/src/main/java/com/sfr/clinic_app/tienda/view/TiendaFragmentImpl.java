package com.sfr.clinic_app.tienda.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfr.clinic_app.databinding.FragmentTiendaBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;

public class TiendaFragmentImpl extends Fragment implements TiendaFragment {
    public TiendaFragmentImpl() {
        // Required empty public constructor
    }

    private FragmentTiendaBinding binding;

    public static TiendaFragmentImpl newInstance() {
        TiendaFragmentImpl fragment = new TiendaFragmentImpl();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {;
        // Utilizamos el objeto de ViewBinding para inflar el diseño
        binding = FragmentTiendaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        return view;
    }

    private void initInjection() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, requireContext()))
                .connectionModule(new ConnectionModule())
                .sharedPreferencesModule(new SharedPreferencesModule(requireContext()))
                .build();
        appComponent.inject(this);
    }

}