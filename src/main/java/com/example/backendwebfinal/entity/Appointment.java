package com.example.backendwebfinal.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @CreationTimestamp
    @Column(nullable = false)
    private Date date;

    @Column(name = "message")
    private String message;

    @OneToOne(mappedBy = "appointment")
    private Patient patient;


    public Appointment() {
    }

    public Appointment(String fullName, String email, Date date, String message, Patient patient) {
        this.fullName = fullName;
        this.email = email;
        this.date = date;
        this.message = message;
    }

}
