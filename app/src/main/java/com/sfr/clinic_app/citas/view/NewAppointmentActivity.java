package com.sfr.clinic_app.citas.view;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.sfr.clinic_app.databinding.ActivityNewAppointmentBinding;

import java.util.Calendar;
import java.util.Date;

public class NewAppointmentActivity extends AppCompatActivity {
    private ActivityNewAppointmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAppointmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /*// Establecer la acción del botón
        binding.btnSubmitAppointment.setOnClickListener(view -> submitAppointment());
    }

   /* private void submitAppointment() {
        String appointmentName = binding.etAppointmentName.getText().toString();
        int day = binding.datePicker.getDayOfMonth();
        int month = binding.datePicker.getMonth();
        int year = binding.datePicker.getYear();
        int hour = binding.timePicker.getCurrentHour();
        int minute = binding.timePicker.getCurrentMinute();

        Calendar appointmentDate = Calendar.getInstance();
        appointmentDate.set(year, month, day, hour, minute);

        // Aquí puedes manejar el envío de la cita (e.g., guardar en Firebase, enviar a un servidor, etc.)
        // Por ejemplo:
        // saveAppointment(appointmentName, appointmentDate.getTime());

        // Muestra un mensaje de éxito o realiza alguna acción adicional
    }

    // Método de ejemplo para guardar la cita (debes implementarlo según tus necesidades)
    private void saveAppointment(String name, Date date) {
        // Implementa la lógica para guardar la cita
    }*/
}
}
