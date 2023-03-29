package com.example.crudinventrack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private int customer_Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    public Customer(String firstName, String last_name, String email) {
        this.firstName = firstName;
        this.last_name = last_name;
        this.email = email;
    }
    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
