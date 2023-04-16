package com.atl.springboot.service;


import com.atl.springboot.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    ResponseEntity<Customer> createCustomer(Customer customer);

    ResponseEntity<Customer> getCustomer(Long id);


//    Customer updateCustomer(Customer customer);
}
