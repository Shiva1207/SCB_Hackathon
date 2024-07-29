package com.scbsena.demo.repository;

import com.scbsena.demo.entity.InvestmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentDetailsRepository extends JpaRepository<InvestmentDetails, String> {

    @Query(nativeQuery = true, value="SELECT * FROM investmentdetails WHERE email = :email")
    InvestmentDetails findByEmail(String email);
}
