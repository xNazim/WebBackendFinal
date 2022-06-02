package com.example.backendwebfinal.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Data
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

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(String fullName, String email, Date date, String message, Patient patient) {
        this.fullName = fullName;
        this.email = email;
        this.date = date;
        this.message = message;
        this.patient = patient;
    }
}
