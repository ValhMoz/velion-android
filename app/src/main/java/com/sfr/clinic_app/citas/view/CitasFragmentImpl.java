package com.sfr.clinic_app.citas.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.citas.adapter.CitasAdapter;
import com.sfr.clinic_app.citas.presenter.CitasPresenter;
import com.sfr.clinic_app.databinding.FragmentCitasBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;

import java.util.ArrayList;

import javax.inject.Inject;


public class CitasFragmentImpl extends Fragment implements CitasFragment, CitasAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private FragmentCitasBinding binding;
    private RecyclerView recyclerView;
    private CitasAdapter adapter;
    @Inject
    CitasPresenter presenter;

    public CitasFragmentImpl() {
        // Required empty public constructor
    }


    public static CitasFragmentImpl newInstance() {
        CitasFragmentImpl fragment = new CitasFragmentImpl();
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
        binding = FragmentCitasBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        recyclerView = binding.recyclerViewReports;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);

        showLoading();
        presenter.onAppointmentsFetched();

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoToRequestNewAppointment(v);
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
    public void showAppointments(ArrayList<Appointment> appointments) {
        hideLoading();
        Log.i("hola", "hola");
//        Log.i("productos", String.valueOf(products));
        // Pasar los datos al adaptador
        adapter = new CitasAdapter(appointments, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
        presenter.onAppointmentsFetched();
        binding.swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onItemClick(Appointment appointments) {

    }

    private void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("¿Deseas cancelar la cita?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();

    }

    private void onGoToRequestNewAppointment(View v){
        startActivity(new Intent(requireContext(), NewAppointmentActivity.class));
    }
}