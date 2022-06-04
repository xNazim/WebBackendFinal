package com.example.backendwebfinal.entity;

import lombok.*;


import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}