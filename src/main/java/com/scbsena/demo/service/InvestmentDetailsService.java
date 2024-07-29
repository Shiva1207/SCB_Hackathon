package com.scbsena.demo.service;

import Model.InvestmentDetailsDto;
import com.scbsena.demo.entity.InvestmentDetails;
import com.scbsena.demo.repository.InvestmentDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvestmentDetailsService {

    @Autowired
    private InvestmentDetailsRepository repository;

    public void save(InvestmentDetailsDto request){

        InvestmentDetails investmentDetails = new InvestmentDetails();

        investmentDetails.setEmail(request.getEmail());
        investmentDetails.setInvestedAmount(request.getInvestedAmount());
        investmentDetails.setInvestmentExperience(request.getInvestmentExperience());
        investmentDetails.setRetirementSaving(request.getRetirementSaving());
        investmentDetails.setEmergencyFund(request.getEmergencyFund());
        investmentDetails.setMonthlyIncome(request.getMonthlyIncome());
        investmentDetails.setRiskTolerance(request.getRiskTolerance());

        repository.save(investmentDetails);
    }

    public InvestmentDetailsDto getDetails(String email){
        InvestmentDetails investmentDetails = repository.findByEmail(email);

        InvestmentDetailsDto investmentDetailsDto = new InvestmentDetailsDto();

        investmentDetailsDto.setEmail(investmentDetails.getEmail());
        investmentDetailsDto.setInvestedAmount(investmentDetails.getInvestedAmount());
        investmentDetailsDto.setInvestmentExperience(investmentDetails.getInvestmentExperience());
        investmentDetailsDto.setEmergencyFund(investmentDetails.getEmergencyFund());
        investmentDetailsDto.setRetirementSaving(investmentDetails.getRetirementSaving());
        investmentDetailsDto.setMonthlyIncome(investmentDetails.getMonthlyIncome());
        investmentDetailsDto.setRiskTolerance(investmentDetails.getRiskTolerance());

        return investmentDetailsDto;
    }

}
