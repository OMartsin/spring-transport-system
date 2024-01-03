package com.example.transportsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 64, unique = true)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 64)
    private String address;
    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String edrpou;

    @Basic(optional = true)
    @Column(nullable = true, length = 16, unique = true)
    private String ipn;

    @Basic(optional = true)
    @Column(nullable = true, length = 64, unique = true)
    private String iban;

    @Basic(optional = true)
    @Column(nullable = true, length = 64)
    private String bank;

    @Basic(optional = true)
    @Column(nullable = true, length = 8)
    private String mfo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Client(String name, String address, String edrpou, String ipn, String iban, String bank, String mfo) {
        this.name = name;
        this.address = address;
        this.edrpou = edrpou;
        this.ipn = ipn;
        this.iban = iban;
        this.bank = bank;
        this.mfo = mfo;
    }

}
