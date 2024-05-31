package com.sfr.clinic_app.tienda.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.FragmentTiendaBinding;
import com.sfr.clinic_app.di.appComponent.AppComponent;
import com.sfr.clinic_app.di.appComponent.DaggerAppComponent;
import com.sfr.clinic_app.di.appModule.AppModule;
import com.sfr.clinic_app.di.appModule.ConnectionModule;
import com.sfr.clinic_app.di.appModule.SharedPreferencesModule;
import com.sfr.clinic_app.tienda.adapter.TiendaAdapter;
import com.sfr.clinic_app.tienda.presenter.TiendaPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

public class TiendaFragmentImpl extends Fragment implements TiendaFragment, TiendaAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    public TiendaFragmentImpl() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private TiendaAdapter adapter;
    private FragmentTiendaBinding binding;
    @Inject
    TiendaPresenter tiendapresenter;

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
        recyclerView = binding.recyclerViewReports;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.swipeRefreshLayout.setOnRefreshListener(this);

        showLoading();
        tiendapresenter.onArticlesFetched();
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
    public void showProducts(ArrayList<Product> products) {
        hideLoading();
        Log.i("hola", "hola");
        adapter = new TiendaAdapter(products, this);
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
        tiendapresenter.onArticlesFetched();
        binding.swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onItemClick(Product product) {

    }
}