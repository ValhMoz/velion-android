package com.sfr.clinic_app.invoice.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sfr.clinic_app.api.Models.Invoice;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.ItemArticleBinding;
import com.sfr.clinic_app.databinding.ItemInvoiceBinding;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>{
    private ArrayList<Invoice> invoices;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Invoice invoice);
    }


    public InvoiceAdapter(ArrayList<Invoice> invoices, OnItemClickListener itemClickListener){
        this.invoices=invoices;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public InvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemInvoiceBinding binding = ItemInvoiceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new InvoiceViewHolder(binding);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull InvoiceViewHolder holder, int position) {
        Invoice invoice = invoices.get(position);
        holder.bind(invoice);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(invoice);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return invoices != null ? invoices.size() : 0;
    }

    public static class InvoiceViewHolder extends RecyclerView.ViewHolder {
        ItemInvoiceBinding binding;

        public InvoiceViewHolder(@NonNull ItemInvoiceBinding itemInvoiceBinding) {
            super(itemInvoiceBinding.getRoot());
            binding = itemInvoiceBinding;
        }

        public void bind(Invoice invoice) {
            binding.purchaseInfoTextView.setText(invoice.getProductoNombre());
            binding.purchasePriceTextView.setText(invoice.getMonto()+"€");
            binding.descriptionTextView.setText(invoice.getEstado());
        }
    }
}
