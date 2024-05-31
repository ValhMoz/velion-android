package com.sfr.clinic_app.tienda.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfr.clinic_app.api.Models.Product;
import com.sfr.clinic_app.databinding.ItemArticleBinding;
import java.util.ArrayList;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>{
    private ArrayList<Product> products;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Product product);
    }


    public TiendaAdapter(ArrayList<Product> products, OnItemClickListener itemClickListener){
        this.products=products;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public TiendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticleBinding binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TiendaViewHolder(binding);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public void onBindViewHolder(@NonNull TiendaViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(product);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products != null ? products.size() : 0;
    }

    public static class TiendaViewHolder extends RecyclerView.ViewHolder {
        ItemArticleBinding binding;

        public TiendaViewHolder(@NonNull ItemArticleBinding itemArticleBinding) {
            super(itemArticleBinding.getRoot());
            binding = itemArticleBinding;
        }

        public void bind(Product product) {
            binding.purchaseInfoTextView.setText(product.getNombre());
            binding.purchasePriceTextView.setText(product.getMonto()+"€");
        }
    }
}
