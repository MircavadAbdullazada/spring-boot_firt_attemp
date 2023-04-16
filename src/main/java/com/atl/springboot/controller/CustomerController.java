package com.atl.springboot.controller;


import com.atl.springboot.entity.Customer;
import com.atl.springboot.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private  final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
       return  customerService.createCustomer( customer);
    }

    @GetMapping("/get/customer")
    public ResponseEntity<Customer> getCustomer (@RequestParam Long id){

        return  customerService.getCustomer(id);
    }


//    @PutMapping("/update")
//    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
//        Customer updatedCustomer = customerService.updateCustomer(customer);
//        if (updatedCustomer != null) {
//            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }



}
