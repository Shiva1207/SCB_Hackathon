package com.scbsena.demo.controller;
import Model.UserDetailsDto;
import com.scbsena.demo.service.CustomerData;
import com.scbsena.demo.service.FinancialAdvisoryService;
import com.scbsena.demo.service.LoginService;
import com.scbsena.demo.service.OpenAIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/advisory")
@Slf4j
@Validated
public class FinancialAdvisoryController {

    @Autowired
    private FinancialAdvisoryService financialAdvisoryService;

    @Autowired
    private OpenAIService openAIService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CustomerData customerData;

    @GetMapping("/getAdvice")
    public String getFinancialAdvice(@RequestBody String query) throws Exception {
        System.out.println(query);
       return openAIService.search(query);
    }

    @GetMapping("/login")
    public ResponseEntity<?> getUserLogin(@RequestParam String email, @RequestParam String password) {
        try {
            boolean result = loginService.login(email, password);
            return new ResponseEntity<Boolean>(result, result ? HttpStatus.OK:HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userDetails")
    public ResponseEntity<?> saveUserDetails(@RequestBody UserDetailsDto userDetailsDto){
        try {
            customerData.saveUserData(userDetailsDto);
            return new ResponseEntity<String>("Data Saved Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>("Error in saving data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}