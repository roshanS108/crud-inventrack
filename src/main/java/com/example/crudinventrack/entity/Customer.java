package com.example.crudinventrack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    
    public Customer(){
        
    }
    public Customer(String firstName, String lastName, String email){
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.email = email; 
    }
    public String getFirstName(){
        return this.firstName;    
    }
    public void setFirstName(String firstName){
        this.firstName = firstName; 
    }
    
    public String getLastName(){
        return this.lastName;    
    }
    public void setLastName(String lastName){
        this.firstName = firstName; 
    }
    
    public String getEmail(){
        return this.email; 
    }
    public void setEmail(String email){
        this.email = email;    
    }
    
    
    
}
