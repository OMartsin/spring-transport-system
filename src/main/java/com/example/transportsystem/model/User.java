package com.example.transportsystem.model;

import com.example.transportsystem.model.driver.Driver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, unique = true, length = 64)
    private String login;
    @Basic(optional = false)
    @Column(nullable = false,  length = 128)
    private String password;

    @OneToOne(mappedBy = "user")
    private Client client;

    @OneToOne(mappedBy = "user")
    private Driver driver;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
