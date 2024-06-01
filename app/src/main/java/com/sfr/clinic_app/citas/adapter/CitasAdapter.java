package com.sfr.clinic_app.citas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sfr.clinic_app.api.Models.Appointment;
import com.sfr.clinic_app.databinding.ItemAppointmentBinding;


import java.util.ArrayList;

public class CitasAdapter extends RecyclerView.Adapter<CitasAdapter.CitasViewHolder>{
    private ArrayList<Appointment> appointments;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Appointment appointments);
    }


    public CitasAdapter(ArrayList<Appointment> appointments, OnItemClickListener itemClickListener){
        this.appointments=appointments;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAppointmentBinding binding = ItemAppointmentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CitasViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.bind(appointment);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(appointment);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return appointments != null ? appointments.size() : 0;
    }

    public static class CitasViewHolder extends RecyclerView.ViewHolder {
        ItemAppointmentBinding binding;

        public CitasViewHolder(@NonNull ItemAppointmentBinding itemAppointmentBinding) {
            super(itemAppointmentBinding.getRoot());
            binding = itemAppointmentBinding;
        }

        public void bind(Appointment appointment) {
            binding.appointmentDateTimeTextView.setText(appointment.getDescription());
            binding.appointmentDateTimeTextView.setText(appointment.getDate());
        }
    }

}
