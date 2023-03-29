package com.example.crudinventrack.dao;

import com.example.crudinventrack.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
