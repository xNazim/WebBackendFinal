package com.example.backendwebfinal.model;

import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class Person {

    /** The id. */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    /** The name. */
    @NotNull
    private String name;

    /** The forename. */
    @NotNull
    private String lastname;

    @NotNull
    private String specialty;

    @NotNull
    private int phone;
    /**
     * Instantiates a new person.
     */
    public Person() {
        super();
    }

    /**
     * Instantiates a new person.
     *
     * @param id the id
     * @param name the name
     *
     */
    public Person(Integer id, String name, String lastname, String specialty, int phone) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.specialty = specialty;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}