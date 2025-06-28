package com.appsoft.Eclinic_Backend.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String specialization;

    private String phone;

    private String password;

    private String role = "DOCTOR";
}

