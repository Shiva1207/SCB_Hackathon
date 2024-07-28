package com.scbsena.demo.service;

import Model.UserDetailsDto;
import com.scbsena.demo.entity.Customer;
import com.scbsena.demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerData {

    @Autowired
    private CustomerRepository repository;

    public void saveUserData(UserDetailsDto userDetails){
        Customer customer = new Customer();
        customer.setEmail(userDetails.getEmail());
        customer.setAge(userDetails.getAge());
        customer.setFirstName(userDetails.getFirstName());
        customer.setLastName(userDetails.getLastName());
        customer.setPassword(userDetails.getPassword());
        customer.setGender(userDetails.getGender());
        repository.save(customer);
    }
}
