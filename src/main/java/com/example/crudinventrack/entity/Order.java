package com.example.crudinventrack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "order_date")
    private String order_date;

    @Column(name = "total_amount")
    private double totalAmount;
}
