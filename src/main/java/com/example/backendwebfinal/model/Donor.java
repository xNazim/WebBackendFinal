package com.example.backendwebfinal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Donor extends PerDonor {



    /** The id. */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

//        /** The teachings. */
//        @OneToMany(cascade = CascadeType.ALL, mappedBy="teacher")
//        private List<Teaching> teachings;

    /**
     * Instantiates a new teacher.
     */
    public Donor() {
        super();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
