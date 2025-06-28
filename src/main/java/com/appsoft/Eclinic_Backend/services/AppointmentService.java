package com.appsoft.Eclinic_Backend.services;


import com.appsoft.Eclinic_Backend.models.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment makeAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void deleteAppointment(Long id);
}
