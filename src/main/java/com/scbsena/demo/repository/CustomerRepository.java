package com.scbsena.demo.repository;

import com.scbsena.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(nativeQuery = true, value="SELECT password FROM customer WHERE email = :email")
    String findByEmail(String email);

}
