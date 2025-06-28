package com.appsoft.Eclinic_Backend.serviceImpl;

import com.appsoft.Eclinic_Backend.Repo.AppointmentRepository;
import com.appsoft.Eclinic_Backend.models.Appointment;
import com.appsoft.Eclinic_Backend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment makeAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
         appointmentRepository.deleteById(id);

    }
}
