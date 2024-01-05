package com.example.transportsystem.model.driver;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "contract")
@NoArgsConstructor
@Getter
@Setter
public class DriverContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private Integer number;

    @Basic(optional = false)
    @Column(nullable = false)
    private Date issueDate;

    private Date expirationDate;

    @ManyToOne
    private Driver driver;

    public DriverContract(Integer number, Date issueDate, Date expirationDate) {
        this.number = number;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    public DriverContract(Integer number, Date issueDate) {
        this.number = number;
        this.issueDate = issueDate;
    }

}
