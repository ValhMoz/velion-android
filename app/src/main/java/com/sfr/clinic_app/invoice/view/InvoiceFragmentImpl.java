package com.sfr.clinic_app.invoice.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.FragmentInvoiceBinding;
import com.sfr.clinic_app.databinding.FragmentTiendaBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.invoice.adapter.InvoiceAdapter;
import com.sfr.clinic_app.invoice.presenter.InvoicePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

public class InvoiceFragmentImpl extends Fragment implements InvoiceFragment, InvoiceAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    public InvoiceFragmentImpl() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private InvoiceAdapter adapter;
    private FragmentInvoiceBinding binding;
    @Inject
    InvoicePresenter invoicepresenter;

    public static InvoiceFragmentImpl newInstance() {
        InvoiceFragmentImpl fragment = new InvoiceFragmentImpl();
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
        binding = FragmentInvoiceBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initInjection();
        recyclerView = binding.recyclerViewReports;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.swipeRefreshLayout.setOnRefreshListener(this);

        showLoading();
        invoicepresenter.onInvoicesFetched();
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
    public void showInvoices(ArrayList<Invoice> invoices) {
        hideLoading();
        adapter = new InvoiceAdapter(invoices, this);
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
        invoicepresenter.onInvoicesFetched();
        binding.swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onItemClick(Invoice invoice) {

    }

    private void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("¿Deseas descargar el justificante?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();

    }
}