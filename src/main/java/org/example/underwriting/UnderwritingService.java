package org.example.underwriting;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;

@Agent(groupName = "underwritingOperations")
@Service
public class UnderwritingService {

    @Action(description = "Assess risk for an insurance application")
    public String assessRisk(String applicantName, int age, String healthStatus, String occupation, boolean smoker) {
        String riskCategory;
        int riskScore = 50;
        
        // Age factor
        if (age > 60) riskScore += 30;
        else if (age > 45) riskScore += 15;
        else if (age < 30) riskScore -= 10;
        
        // Health factor
        if (healthStatus.equalsIgnoreCase("EXCELLENT")) riskScore -= 20;
        else if (healthStatus.equalsIgnoreCase("GOOD")) riskScore -= 10;
        else if (healthStatus.equalsIgnoreCase("FAIR")) riskScore += 10;
        else if (healthStatus.equalsIgnoreCase("POOR")) riskScore += 30;
        
        // Smoking factor
        if (smoker) riskScore += 25;
        
        // Occupation factor
        if (occupation.toLowerCase().contains("construction") || 
            occupation.toLowerCase().contains("mining")) {
            riskScore += 20;
        }
        
        if (riskScore < 40) riskCategory = "LOW";
        else if (riskScore < 70) riskCategory = "MEDIUM";
        else riskCategory = "HIGH";
        
        return String.format("Risk Assessment for %s:\n" +
               "=================================\n" +
               "Age: %d years\n" +
               "Health Status: %s\n" +
               "Occupation: %s\n" +
               "Smoker: %s\n" +
               "Risk Score: %d/100\n" +
               "Risk Category: %s\n" +
               "Recommendation: %s", 
               applicantName, age, healthStatus, occupation, smoker ? "Yes" : "No",
               riskScore, riskCategory,
               riskCategory.equals("LOW") ? "APPROVED - Standard rates" :
               riskCategory.equals("MEDIUM") ? "APPROVED - Moderate premium adjustment" :
               "REQUIRES ADDITIONAL REVIEW - High risk premium or limited coverage");
    }

    @Action(description = "Calculate premium rate based on risk factors")
    public String calculatePremiumRate(String policyType, String riskCategory, double coverageAmount) {
        double baseRate;
        
        switch (policyType.toLowerCase()) {
            case "life":
                baseRate = 0.003;
                break;
            case "auto":
                baseRate = 0.015;
                break;
            case "home":
                baseRate = 0.008;
                break;
            case "health":
                baseRate = 0.05;
                break;
            default:
                baseRate = 0.01;
        }
        
        double riskMultiplier = riskCategory.equalsIgnoreCase("HIGH") ? 2.0 :
                               riskCategory.equalsIgnoreCase("MEDIUM") ? 1.3 : 1.0;
        
        double annualPremium = coverageAmount * baseRate * riskMultiplier;
        
        return String.format("Premium Rate Calculation:\n" +
               "=================================\n" +
               "Policy Type: %s Insurance\n" +
               "Coverage Amount: $%.2f\n" +
               "Base Rate: %.3f%%\n" +
               "Risk Category: %s (%.1fx multiplier)\n" +
               "Annual Premium: $%.2f\n" +
               "Monthly Premium: $%.2f\n" +
               "Quarterly Premium: $%.2f", 
               policyType, coverageAmount, baseRate * 100, riskCategory, riskMultiplier,
               annualPremium, annualPremium / 12, annualPremium / 4);
    }

    @Action(description = "Evaluate coverage eligibility")
    public String evaluateEligibility(String applicantName, String policyType, String preExistingConditions) {
        boolean eligible = true;
        String restrictions = "None";
        
        if (policyType.equalsIgnoreCase("HEALTH") && 
            !preExistingConditions.equalsIgnoreCase("NONE")) {
            restrictions = "Pre-existing conditions excluded for first 12 months";
        }
        
        return String.format("Eligibility Evaluation for %s:\n" +
               "=================================\n" +
               "Policy Type: %s\n" +
               "Pre-existing Conditions: %s\n" +
               "Eligibility Status: %s\n" +
               "Coverage Restrictions: %s\n" +
               "Approval Status: %s", 
               applicantName, policyType, preExistingConditions,
               eligible ? "ELIGIBLE" : "NOT ELIGIBLE",
               restrictions,
               eligible ? "APPROVED WITH CONDITIONS" : "DECLINED");
    }

    @Action(description = "Generate risk report")
    public String generateRiskReport(String applicationId) {
        return String.format("Underwriting Risk Report\n" +
               "Application ID: %s\n" +
               "=================================\n\n" +
               "APPLICANT PROFILE:\n" +
               "Name: John Smith\n" +
               "Age: 42 years\n" +
               "Gender: Male\n" +
               "Occupation: Software Engineer\n\n" +
               "HEALTH ASSESSMENT:\n" +
               "Overall Health: Good\n" +
               "BMI: 24.5 (Normal)\n" +
               "Blood Pressure: 120/80 (Normal)\n" +
               "Cholesterol: 180 mg/dL (Normal)\n" +
               "Medical History: No major conditions\n\n" +
               "LIFESTYLE FACTORS:\n" +
               "Smoker: No\n" +
               "Alcohol Use: Moderate\n" +
               "Exercise: Regular\n\n" +
               "RISK ANALYSIS:\n" +
               "Overall Risk Score: 45/100\n" +
               "Risk Category: LOW-MEDIUM\n" +
               "Mortality Risk: Low\n" +
               "Morbidity Risk: Low\n\n" +
               "RECOMMENDATION:\n" +
               "Status: APPROVED\n" +
               "Premium Loading: Standard +5%%\n" +
               "Special Conditions: None\n" +
               "Report Date: %s", 
               applicationId, java.time.LocalDate.now());
    }

    @Action(description = "Approve or decline insurance application")
    public String processApplication(String applicationId, String decision, String reason) {
        return String.format("Application %s - %s\n" +
               "=================================\n" +
               "Decision: %s\n" +
               "Reason: %s\n" +
               "Decision Date: %s\n" +
               "Underwriter: Michael Thompson\n" +
               "Next Steps: %s", 
               applicationId, decision.toUpperCase(), decision.toUpperCase(), reason,
               java.time.LocalDate.now(),
               decision.equalsIgnoreCase("APPROVED") ? 
                   "Policy documents will be generated and sent for signature" :
                   "Applicant will be notified with appeal rights information");
    }

    @Action(description = "Set policy terms and conditions")
    public String setPolicyTerms(String policyType, int termLength, double coverageAmount) {
        return String.format("Policy Terms Configuration:\n" +
               "=================================\n" +
               "Policy Type: %s\n" +
               "Term Length: %d years\n" +
               "Coverage Amount: $%.2f\n" +
               "Deductible: $1,000\n" +
               "Co-insurance: 80/20\n" +
               "Out-of-Pocket Max: $5,000/year\n" +
               "Waiting Period: 30 days\n" +
               "Grace Period: 30 days\n" +
               "Renewal: Automatic (subject to review)\n" +
               "Cancellation: 30 days notice required", 
               policyType, termLength, coverageAmount);
    }
}
