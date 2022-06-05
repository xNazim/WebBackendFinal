package com.example.backendwebfinal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "app_id", referencedColumnName = "id")
    private Appointment appointment;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String email, String phone, String sex, int age, Appointment appointment, Doctor doctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.appointment = appointment;
        this.doctor = doctor;
    }
}
