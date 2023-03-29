package com.example.crudinventrack.Service;

import com.example.crudinventrack.dao.CustomerRepository;
import com.example.crudinventrack.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    //save customer to the database
    @Override
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }
}
