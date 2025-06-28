package com.appsoft.Eclinic_Backend.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendPasswordToDoctor(String toEmail, String doctorName, String rawPassword) {
        String subject = "E-Clinic: Your Account Login Details";
        String body = String.format(
                "Dear Dr. %s,\n\nYour account has been created successfully.\n" +
                        "Here are your login credentials:\n\n" +
                        "Email: %s\n" +
                        "Password: %s\n\n" +
                        "Please login and change your password after first login.\n\nRegards,\nE-Clinic Team",
                doctorName, toEmail, rawPassword
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
