package com.sfr.clinic_app.inicio.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfr.clinic_app.api.Models.MedicalReport;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.ItemMedicalReportBinding;
import com.sfr.clinic_app.inicio.view.InicioFragmentImpl;

import java.util.ArrayList;

public class InicioAdapter extends RecyclerView.Adapter<InicioAdapter.InicioViewHolder>{
    private ArrayList<MedicalReport> reports;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(MedicalReport report);
    }

    public InicioAdapter(ArrayList<MedicalReport> reports, OnItemClickListener itemClickListener){
        this.reports=reports;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public InicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMedicalReportBinding binding = ItemMedicalReportBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new InicioViewHolder(binding);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull InicioViewHolder holder, int position) {
        MedicalReport report = reports.get(position);
        holder.bind(report);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(report);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return reports != null ? reports.size() : 0;
    }

    public static class InicioViewHolder extends RecyclerView.ViewHolder {
        ItemMedicalReportBinding binding;

        public InicioViewHolder(@NonNull ItemMedicalReportBinding itemMedicalReportBinding) {
            super(itemMedicalReportBinding.getRoot());
            binding = itemMedicalReportBinding;
        }

        public void bind(MedicalReport report) {
            binding.textTitle.setText(report.getEspecialidad());
            binding.DateTimeTextView.setText(report.getDate());
            Log.i("prueba", ""+report.getDate());
            binding.textDescription.setText(report.getDiagnostico());
        }
    }
}
