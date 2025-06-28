package com.appsoft.Eclinic_Backend.controllers;


import com.appsoft.Eclinic_Backend.models.Appointment;
import com.appsoft.Eclinic_Backend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;


    @GetMapping({"", "/"})
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "patients/appointments";  // Your thymeleaf template path
    }

    @PostMapping("/book")
    public String bookAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
        appointmentService.makeAppointment(appointment);
        model.addAttribute("successMessage", "Appointment booked successfully!");
        return "patients/appointments";
    }



}

