package org.example.claimsprocessing;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Agent(groupName = "claimsProcessingOperations")
@Service
public class ClaimsProcessingService {

    @Action(description = "Submit a new insurance claim")
    public String submitClaim(String policyNumber, String claimType, double claimAmount, String description) {
        String claimNumber = "CLM-" + (System.currentTimeMillis() % 100000);
        return String.format("Claim submitted successfully!\n" +
               "Claim Number: %s\n" +
               "Policy Number: %s\n" +
               "Claim Type: %s\n" +
               "Claim Amount: $%.2f\n" +
               "Description: %s\n" +
               "Status: PENDING REVIEW\n" +
               "Submitted: %s\n" +
               "Expected Processing Time: 5-7 business days", 
               claimNumber, policyNumber, claimType, claimAmount, description,
               LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Action(description = "Get claim status")
    public String getClaimStatus(String claimNumber) {
        String[] statuses = {"PENDING REVIEW", "UNDER INVESTIGATION", "APPROVED", "PAID", "DENIED"};
        int index = Math.abs(claimNumber.hashCode() % statuses.length);
        String status = statuses[index];
        
        return String.format("Claim Status for %s:\n" +
               "=================================\n" +
               "Current Status: %s\n" +
               "Claim Amount: $5,000.00\n" +
               "Submitted Date: 2026-01-15\n" +
               "Last Updated: %s\n" +
               "Assigned Adjuster: Sarah Johnson\n" +
               "Notes: %s", 
               claimNumber, status, java.time.LocalDate.now(),
               status.equals("APPROVED") ? "All documentation verified. Payment processing initiated." :
               status.equals("DENIED") ? "Claim does not meet policy coverage criteria." :
               "Claim is being reviewed by our team.");
    }

    @Action(description = "Approve a claim")
    public String approveClaim(String claimNumber, double approvedAmount) {
        return String.format("Claim %s has been APPROVED.\n" +
               "Approved Amount: $%.2f\n" +
               "Approval Date: %s\n" +
               "Payment Method: Direct Deposit\n" +
               "Expected Payment Date: %s\n" +
               "Status: APPROVED - PAYMENT PENDING", 
               claimNumber, approvedAmount, java.time.LocalDate.now(),
               java.time.LocalDate.now().plusDays(3));
    }

    @Action(description = "Deny a claim")
    public String denyClaim(String claimNumber, String reason) {
        return String.format("Claim %s has been DENIED.\n" +
               "Reason: %s\n" +
               "Denial Date: %s\n" +
               "Status: DENIED\n" +
               "Appeal Information: You may appeal this decision within 30 days.", 
               claimNumber, reason, java.time.LocalDate.now());
    }

    @Action(description = "Request additional documentation for a claim")
    public String requestDocumentation(String claimNumber, String documentsNeeded) {
        return String.format("Additional documentation requested for Claim %s:\n" +
               "Documents Required:\n%s\n" +
               "Deadline: %s\n" +
               "Submission Method: Upload to customer portal or email to claims@insurance.com\n" +
               "Status: PENDING DOCUMENTATION", 
               claimNumber, documentsNeeded, java.time.LocalDate.now().plusDays(10));
    }

    @Action(description = "Calculate claim payout amount")
    public String calculateClaimPayout(String claimNumber, double claimAmount, double deductible, double coveragePercentage) {
        double payoutAmount = (claimAmount - deductible) * (coveragePercentage / 100.0);
        payoutAmount = Math.max(0, payoutAmount);
        
        return String.format("Claim Payout Calculation for %s:\n" +
               "=================================\n" +
               "Total Claim Amount: $%.2f\n" +
               "Policy Deductible: $%.2f\n" +
               "Coverage Percentage: %.0f%%\n" +
               "Eligible Amount: $%.2f\n" +
               "Final Payout Amount: $%.2f", 
               claimNumber, claimAmount, deductible, coveragePercentage,
               claimAmount - deductible, payoutAmount);
    }

    @Action(description = "Get claims summary for a policy")
    public String getClaimsSummary(String policyNumber) {
        return String.format("Claims Summary for Policy %s:\n\n", policyNumber) +
               "Total Claims: 3\n" +
               "Approved: 2 ($8,500)\n" +
               "Denied: 0\n" +
               "Pending: 1 ($5,000)\n\n" +
               "Recent Claims:\n" +
               "1. CLM-12345 - Medical - $3,500 - PAID\n" +
               "2. CLM-12346 - Auto Accident - $5,000 - PAID\n" +
               "3. CLM-12347 - Property Damage - $5,000 - PENDING REVIEW";
    }

    @Action(description = "Process claim payment")
    public String processPayment(String claimNumber, double amount, String paymentMethod) {
        String transactionId = "TXN-" + (System.currentTimeMillis() % 100000);
        return String.format("Payment processed for Claim %s:\n" +
               "Transaction ID: %s\n" +
               "Payment Amount: $%.2f\n" +
               "Payment Method: %s\n" +
               "Processing Date: %s\n" +
               "Status: COMPLETED", 
               claimNumber, transactionId, amount, paymentMethod,
               LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
