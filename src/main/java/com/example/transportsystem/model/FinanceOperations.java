package com.example.transportsystem.model;

import com.example.transportsystem.model.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "finance_operations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinanceOperations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private Double amount;

    @Basic(optional = false)
    @Column(nullable = false)
    private Timestamp timestamp;

    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String type;

    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false, length = 128)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

}
