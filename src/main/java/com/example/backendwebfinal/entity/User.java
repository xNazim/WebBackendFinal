package com.example.backendwebfinal.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean enabled;
//    private boolean enabled;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    public User() {
    }

    public User(String firstName, String lastName, String username, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String firstName, String lastName, String username, String password, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }


    @Transient
    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = roles.iterator();

        while (iterator.hasNext()) {
            Role roles = iterator.next();
            if (roles.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}