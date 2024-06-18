package com.sfr.clinic_app.configuracion.view;

import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.Models.User;
import com.sfr.clinic_app.configuracion.presenter.ConfigPresenter;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sfr.clinic_app.databinding.FragmentConfiguracionBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.login.view.LoginActivity;
import com.sfr.clinic_app.login.view.RegisterActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class ConfigFragmentImpl extends Fragment implements ConfigFragment  {

    @Inject
    SharedPreferences sharedPreferences;
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

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v);
            }
        });

        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatos(v);
            }
        });

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
            binding.textViewUsername.setText(usuario.getName()+" "+usuario.getSurname());
            binding.textViewEmail.setText(usuario.getEmail());
        }

    }

    @Override
    public void showUserUpdatedDataMessage() {
        configPresenter.onUsersFetched();
        Toast.makeText(requireContext(), "Datos actualizados correctamente.", Toast.LENGTH_SHORT).show();
    }

    public void actualizarDatos(View v) {
       String newEmail =  binding.editTextEmail.getText().toString();
       String newPass = binding.editTextPassword.getText().toString();
       configPresenter.onUpdateUserData(newEmail, newPass);

    }

    private void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Estás a punto de cerrar sesión.");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               signout(v);

            }
        });

        builder.create().show();

    }

    private void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.bodylayout.setVisibility(View.INVISIBLE);
    }

    private void hideLoading() {
        binding.progressBar.setVisibility(View.GONE);
        binding.bodylayout.setVisibility(View.VISIBLE);
    }



    public void signout(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(requireContext(), "Se ha cerrado sesión y todos los datos han sido borrados.", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(requireContext(), LoginActivity.class));
        requireActivity().finish();
    }

}