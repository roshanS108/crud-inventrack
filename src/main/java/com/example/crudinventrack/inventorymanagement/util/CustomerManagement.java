package com.example.crudinventrack.inventorymanagement.util;
import com.example.crudinventrack.Service.CustomerService;
import com.example.crudinventrack.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CustomerManagement{

    private CustomerService customerService;


    //inject the customerService in constructor
    @Autowired
    public CustomerManagement(CustomerService customerService){
        this.customerService = customerService;
    }

    //register the customer into the database
    public void registerTheCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Greeting and Welcome to the Registration Process");
        System.out.println("Enter your name: ");
        String firstName = scanner.next();

        System.out.println("Enter your last name: ");
        String lastName = scanner.next();

        System.out.println("Enter your email: ");
        String email = scanner.next();

        //add customer into the database
        Customer customer = new Customer(firstName,lastName,email);
        //save the data to the database
        customerService.saveCustomer(customer);
        System.out.println("You are successfully registered!!" + customer.getFirstName());


    }

}
