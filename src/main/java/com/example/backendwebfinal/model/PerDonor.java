package com.example.backendwebfinal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class PerDonor {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * The name.
     */
    @NotNull
    private String name;

    /**
     * The forename.
     */
    @NotNull
    private String email;

    @NotNull
    private String date;

    @NotNull
    private String time;

    @NotNull
    private String message;

    /**
     * Instantiates a new person.
     */
    public PerDonor() {
        super();
    }

    /**
     * Instantiates a new person.
     *
     * @param id   the id
     * @param name the name
     */
    public PerDonor(Integer id, String name, String email, String date, String time, String message) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.time = time;
        this.message = message;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}