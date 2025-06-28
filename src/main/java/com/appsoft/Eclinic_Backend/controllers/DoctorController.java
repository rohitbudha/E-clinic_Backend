package com.appsoft.Eclinic_Backend.controllers;

import com.appsoft.Eclinic_Backend.Repo.PatientRepository;
import com.appsoft.Eclinic_Backend.models.Doctor;
import com.appsoft.Eclinic_Backend.models.Patient;
import com.appsoft.Eclinic_Backend.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/doctors")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientRepository patientRepository;

//    @GetMapping("/dashboard")
//    public String doctorDashboard() {
//        return "doctors/dashboard";
//    }


    @GetMapping("/dashboard")
    public String showDoctorDashboard(Model model, Principal principal) {
        String email = principal.getName();

        Optional<Patient> optionalDoctor = patientRepository.findByEmail(email);

        if (optionalDoctor.isPresent() && "DOCTOR".equalsIgnoreCase(optionalDoctor.get().getRole())) {
            Patient doctor = optionalDoctor.get();
            model.addAttribute("name", doctor.getFullName());
            return "doctors/dashboard";
        } else {
            return "redirect:/login"; // or custom unauthorized page
        }
    }

    @GetMapping("/addDoctor")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctors/addDoctor";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor, Model model) {
        doctorService.addDoctor(doctor);
        model.addAttribute("successMessage", "Doctor added successfully!");
        model.addAttribute("doctor", new Doctor()); // reset form
        return "doctors/addDoctor";

    }



}

