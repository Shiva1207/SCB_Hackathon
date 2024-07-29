package com.scbsena.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="investmentdetails")
public class InvestmentDetails {

    @Id
    @Column(name="email")
    private String email;

    @Column(name="invested_amount")
    private float investedAmount;

    @Column(name="emergency_fund")
    private float emergencyFund;

    @Column(name="retirement_saving")
    private float retirementSaving;

    @Column(name="investment_experience")
    private String investmentExperience;

    @Column(name="monthly_income")
    private String monthlyIncome;

    @Column(name="risk_tolerance")
    private float riskTolerance;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getInvestedAmount() {
        return investedAmount;
    }

    public void setInvestedAmount(float investedAmount) {
        this.investedAmount = investedAmount;
    }

    public float getEmergencyFund() {
        return emergencyFund;
    }

    public void setEmergencyFund(float emergencyFund) {
        this.emergencyFund = emergencyFund;
    }

    public float getRetirementSaving() {
        return retirementSaving;
    }

    public void setRetirementSaving(float retirementSaving) {
        this.retirementSaving = retirementSaving;
    }

    public String getInvestmentExperience() {
        return investmentExperience;
    }

    public void setInvestmentExperience(String investmentExperience) {
        this.investmentExperience = investmentExperience;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public float getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(float riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

}
