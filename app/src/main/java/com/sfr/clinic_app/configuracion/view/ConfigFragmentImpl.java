package com.sfr.clinic_app.configuracion.view;

import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.configuracion.presenter.ConfigPresenter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfr.clinic_app.databinding.FragmentConfiguracionBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;

import java.util.ArrayList;

import javax.inject.Inject;

public class ConfigFragmentImpl extends Fragment implements ConfigFragment, SwipeRefreshLayout.OnRefreshListener  {
    public ConfigFragmentImpl() {
        // Required empty public constructor
    }

    private FragmentConfiguracionBinding binding;
    @Inject
    ConfigPresenter configPresenter;

    public static ConfigFragmentImpl newInstance() {
        ConfigFragmentImpl fragment = new ConfigFragmentImpl();
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
        binding = FragmentConfiguracionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        showLoading();
        configPresenter.onUsersFetched();

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

    @Override
    public void showUsers(ArrayList<User> user) {
        hideLoading();
        for (User usuario: user){
            binding.textViewUsername.setText(usuario.getName());
            binding.textViewFullName.setText(String.format("%s %s", usuario.getName(), usuario.getSurname()));
            binding.textViewDNI.setText(usuario.getId());
            binding.textViewAddress.setText(usuario.getAddress());
            binding.textViewEmail.setText(usuario.getEmail());
            binding.textViewPhone.setText(usuario.getPhone());
            binding.textViewBirthDate.setText(usuario.getBirthdate());
            binding.textViewGender.setText(usuario.getGender());
        }

    }

    private void hideLoading() {
        // Ocultar el TextView y el ProgressBar
        binding.progressBar.setVisibility(View.GONE);
        binding.swipeRefreshLayout.setVisibility(View.VISIBLE);

    }

    private void showLoading() {
        // Mostrar el TextView y el ProgressBar
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.swipeRefreshLayout.setVisibility(View.GONE);

    }

    @Override
    public void onRefresh() {
        configPresenter.onUsersFetched();
        binding.swipeRefreshLayout.setRefreshing(false);


    }
}