package com.atl.springboot.service.implemantion;


import com.atl.springboot.entity.Customer;
import com.atl.springboot.exception.CustomerExistsException;
import com.atl.springboot.exception.NoSuchCustomerException;
import com.atl.springboot.repository.CustomerRepository;
import com.atl.springboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

//    private final List<Customer> customers= Arrays.asList(
//            Customer.builder().id(1L).name("Cristiano").address("Portugal").build(),
//            Customer.builder().id(2L).name("Lionel").address("Argentina").build(),
//            Customer.builder().id(3L).name("Sergio").address("Spain").build());



    @Override
    @SneakyThrows
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        Optional<Customer> customerFromDb = customerRepository.findById(customer.getId());
//        Optional<Customer> optionalCustomer = customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst();
        if (customerFromDb.isPresent()) {
            throw new CustomerExistsException("Customer with id:" + customer.getId() + " exists");
        }
        customerRepository.save(customer);
        return ResponseEntity.status(404).body(customer);

    }


    @Override
    @SneakyThrows
    public ResponseEntity<Customer> getCustomer(Long id) {
//        Customer customer = customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(
//                () -> new NoSuchCustomerException("Customer with id:" + id + " does not exists "));
        Customer customer = customerRepository.findById(id).stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(
                () -> new NoSuchCustomerException("Customer with id:" + id + " does not exists "));
        return ResponseEntity.status(404).body(customer);

    }



}
