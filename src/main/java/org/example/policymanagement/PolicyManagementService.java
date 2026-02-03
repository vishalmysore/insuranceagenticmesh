package org.example.policymanagement;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;

@Agent(groupName = "policyManagementOperations")
@Service
public class PolicyManagementService {

    @Action(description = "Create a new insurance policy")
    public String createPolicy(String policyType, String customerName, double coverageAmount) {
        String policyNumber = "POL-" + (System.currentTimeMillis() % 100000);
        return String.format("Policy created successfully!\n" +
               "Policy Number: %s\n" +
               "Policy Type: %s\n" +
               "Customer: %s\n" +
               "Coverage Amount: $%.2f\n" +
               "Status: ACTIVE\n" +
               "Created: %s", 
               policyNumber, policyType, customerName, coverageAmount, 
               java.time.LocalDate.now());
    }

    @Action(description = "Renew an existing insurance policy")
    public String renewPolicy(String policyNumber, int renewalYears) {
        return String.format("Policy %s renewed successfully for %d year(s).\n" +
               "New Expiration Date: %s\n" +
               "Renewal Premium: $1,250.00\n" +
               "Status: ACTIVE", 
               policyNumber, renewalYears,
               java.time.LocalDate.now().plusYears(renewalYears));
    }

    @Action(description = "Cancel an insurance policy")
    public String cancelPolicy(String policyNumber, String reason) {
        return String.format("Policy %s has been cancelled.\n" +
               "Reason: %s\n" +
               "Cancellation Date: %s\n" +
               "Refund Amount: $450.00\n" +
               "Status: CANCELLED", 
               policyNumber, reason, java.time.LocalDate.now());
    }

    @Action(description = "Get policy details")
    public String getPolicyDetails(String policyNumber) {
        return String.format("Policy Details for %s:\n" +
               "=================================\n" +
               "Policy Type: Life Insurance\n" +
               "Customer: John Doe\n" +
               "Coverage Amount: $500,000\n" +
               "Premium: $1,250/year\n" +
               "Start Date: 2025-01-01\n" +
               "Expiration Date: 2045-01-01\n" +
               "Status: ACTIVE\n" +
               "Beneficiaries: Jane Doe, Robert Doe", 
               policyNumber);
    }

    @Action(description = "Update policy information")
    public String updatePolicy(String policyNumber, String updateType, String newValue) {
        return String.format("Policy %s updated successfully.\n" +
               "Update Type: %s\n" +
               "New Value: %s\n" +
               "Effective Date: %s", 
               policyNumber, updateType, newValue, java.time.LocalDate.now());
    }

    @Action(description = "Calculate premium for a policy")
    public String calculatePremium(String policyType, int age, double coverageAmount, String riskCategory) {
        double basePremium = coverageAmount * 0.0025;
        double ageFactor = age > 50 ? 1.5 : 1.0;
        double riskFactor = riskCategory.equalsIgnoreCase("HIGH") ? 2.0 : 
                           riskCategory.equalsIgnoreCase("MEDIUM") ? 1.3 : 1.0;
        double totalPremium = basePremium * ageFactor * riskFactor;
        
        return String.format("Premium Calculation:\n" +
               "=================================\n" +
               "Policy Type: %s\n" +
               "Coverage Amount: $%.2f\n" +
               "Base Premium: $%.2f\n" +
               "Age Factor (Age %d): %.2fx\n" +
               "Risk Category: %s (%.2fx)\n" +
               "Annual Premium: $%.2f\n" +
               "Monthly Premium: $%.2f", 
               policyType, coverageAmount, basePremium, age, ageFactor,
               riskCategory, riskFactor, totalPremium, totalPremium / 12);
    }

    @Action(description = "List all active policies for a customer")
    public String listCustomerPolicies(String customerId) {
        return String.format("Active Policies for Customer %s:\n\n", customerId) +
               "1. POL-12345 - Life Insurance - $500,000 - Active\n" +
               "2. POL-12346 - Auto Insurance - $50,000 - Active\n" +
               "3. POL-12347 - Home Insurance - $300,000 - Active\n" +
               "Total Policies: 3 | Total Annual Premium: $3,500";
    }
}
