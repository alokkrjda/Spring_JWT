package org.example.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "ecommerce-user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password1")
    private String password1;

    @Column(name = "password2")
    private String password2;

    @Column(name = "email")
    private String email;
}
