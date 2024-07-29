package Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentDetailsDto {

    private String email;
    private float investedAmount;
    private float emergencyFund;
    private float retirementSaving;
    private String investmentExperience;
    private String monthlyIncome;
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
