package com.sfr.clinic_app.inicio.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfr.clinic_app.databinding.FragmentInicioBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.inicio.presenter.InicioPresenter;
import javax.inject.Inject;

public class InicioFragmentImpl extends Fragment implements InicioFragment {
    public InicioFragmentImpl() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    @Inject
    InicioPresenter inicioPresenter;
    private FragmentInicioBinding binding;

    public static InicioFragmentImpl newInstance() {
        InicioFragmentImpl fragment = new InicioFragmentImpl();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Utilizamos el objeto de ViewBinding para inflar el diseño
        binding = FragmentInicioBinding.inflate(inflater, container, false);
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