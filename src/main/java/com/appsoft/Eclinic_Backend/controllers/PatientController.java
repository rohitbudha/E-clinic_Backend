package com.appsoft.Eclinic_Backend.controllers;

import com.appsoft.Eclinic_Backend.Repo.PatientRepository;
import com.appsoft.Eclinic_Backend.models.ContactMessage;
import com.appsoft.Eclinic_Backend.models.Patient;
import com.appsoft.Eclinic_Backend.serviceImpl.PatientServiceImpl;
import com.appsoft.Eclinic_Backend.services.ContactMessageService;
import com.appsoft.Eclinic_Backend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ContactMessageService messageService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/register"; // Thymeleaf template: register.html
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute Patient patient, Model model) {
        patient.setRole("PATIENT");
        patientService.registerPatient(patient);
        model.addAttribute("successMessage", "Patient registered successfully!");
        model.addAttribute("patient", new Patient());
        return "patients/register"; // Another HTML page or redirect
    }


//
//    @GetMapping("/contact")
//    public String contactPage() {
//
//        return "patients/contact"; // loads templates/contact.html
//    }

    @GetMapping("/our-doctors")
    public String showDoctors() {

        return "patients/doctor"; // loads templates/contact.html
    }


        @GetMapping("/contact")
        public String showContactForm(Model model) {
            model.addAttribute("contactMessage", new ContactMessage());
            return "patients/contact"; // HTML file: templates/patients/contact.html
        }

        @PostMapping("/contact")
        public String handleContactSubmit(@ModelAttribute("contactMessage") ContactMessage message, Model model) {
            messageService.saveMessage(message);
            model.addAttribute("successMessage", "Your message has been submitted successfully!");
            model.addAttribute("contactMessage", new ContactMessage());
            return "patients/contact"; // reload page with success message
        }
    }



