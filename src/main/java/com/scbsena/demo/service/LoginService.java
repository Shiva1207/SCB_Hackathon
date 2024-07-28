package com.scbsena.demo.service;

import com.scbsena.demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private CustomerRepository repository;
    public boolean login(String email, String password){
        String getPassword = repository.findByEmail(email);
        return getPassword.toString().equals(password);
    }
}
