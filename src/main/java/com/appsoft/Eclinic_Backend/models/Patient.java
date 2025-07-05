package com.appsoft.Eclinic_Backend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private int age;
    private String gender;
    private String address;
    private String password;
    private String role;

    public Patient() {
    }


    public Patient(Long id, String fullName, String email, String phone, int age, String gender, String address, String password, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.password = password;
        this.role=role;
    }

}


