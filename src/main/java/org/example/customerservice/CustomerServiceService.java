package org.example.customerservice;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;

@Agent(groupName = "customerServiceOperations")
@Service
public class CustomerServiceService {

    @Action(description = "Get customer account information")
    public String getCustomerAccount(String customerId) {
        return String.format("Customer Account Information\n" +
               "Customer ID: %s\n" +
               "=================================\n" +
               "Name: John Doe\n" +
               "Email: john.doe@email.com\n" +
               "Phone: (555) 123-4567\n" +
               "Address: 123 Main St, Springfield, IL 62701\n" +
               "Date of Birth: 1984-05-15\n" +
               "Customer Since: 2020-03-10\n" +
               "Account Status: ACTIVE\n" +
               "Preferred Contact: Email\n" +
               "Active Policies: 3\n" +
               "Total Premium: $3,500/year", 
               customerId);
    }

    @Action(description = "Update customer information")
    public String updateCustomerInfo(String customerId, String field, String newValue) {
        return String.format("Customer information updated successfully.\n" +
               "Customer ID: %s\n" +
               "Field Updated: %s\n" +
               "New Value: %s\n" +
               "Update Date: %s\n" +
               "Status: CONFIRMED", 
               customerId, field, newValue, java.time.LocalDateTime.now());
    }

    @Action(description = "Handle customer inquiry")
    public String handleInquiry(String customerId, String inquiryType, String question) {
        String response;
        
        switch (inquiryType.toLowerCase()) {
            case "policy":
                response = "Your policy information has been retrieved. You have 3 active policies " +
                          "with total coverage of $850,000. Would you like details on a specific policy?";
                break;
            case "claim":
                response = "I can help you with your claim. Please provide your claim number, " +
                          "or I can look up recent claims on your account.";
                break;
            case "payment":
                response = "Your last payment of $291.67 was received on Jan 15, 2026. " +
                          "Next payment due: Feb 15, 2026. Would you like to make a payment now?";
                break;
            case "coverage":
                response = "I can review your current coverage and suggest any gaps. " +
                          "Your current policies include Life, Auto, and Home insurance.";
                break;
            default:
                response = "Thank you for your inquiry. A customer service representative " +
                          "will review your question and respond within 24 hours.";
        }
        
        return String.format("Customer Inquiry Response\n" +
               "Customer ID: %s\n" +
               "=================================\n" +
               "Inquiry Type: %s\n" +
               "Question: %s\n\n" +
               "Response:\n%s\n\n" +
               "Ticket Number: TKT-%d\n" +
               "Agent: Virtual Assistant\n" +
               "Response Time: %s", 
               customerId, inquiryType, question, response,
               System.currentTimeMillis() % 100000,
               java.time.LocalDateTime.now());
    }

    @Action(description = "Schedule appointment with agent")
    public String scheduleAppointment(String customerId, String appointmentType, String preferredDate) {
        return String.format("Appointment Scheduled Successfully\n" +
               "=================================\n" +
               "Customer ID: %s\n" +
               "Appointment Type: %s\n" +
               "Date: %s\n" +
               "Time: 2:00 PM\n" +
               "Duration: 45 minutes\n" +
               "Agent: Sarah Johnson\n" +
               "Location: Virtual Meeting\n" +
               "Meeting Link: https://insurance.com/meet/abc123\n" +
               "Confirmation Number: APT-%d\n" +
               "Reminder: You will receive email and SMS reminders 24 hours before", 
               customerId, appointmentType, preferredDate,
               System.currentTimeMillis() % 100000);
    }

    @Action(description = "Generate policy documents")
    public String generateDocuments(String policyNumber, String documentType) {
        return String.format("Document Generation Request\n" +
               "=================================\n" +
               "Policy Number: %s\n" +
               "Document Type: %s\n" +
               "Generation Status: COMPLETED\n" +
               "Document ID: DOC-%d\n" +
               "Generated Date: %s\n" +
               "Download Link: https://insurance.com/docs/download/%d\n" +
               "Valid Until: %s\n" +
               "Format: PDF\n" +
               "Note: Document will be sent to your registered email address", 
               policyNumber, documentType, System.currentTimeMillis() % 100000,
               java.time.LocalDateTime.now(), System.currentTimeMillis() % 100000,
               java.time.LocalDate.now().plusDays(30));
    }

    @Action(description = "Process customer payment")
    public String processPayment(String customerId, String policyNumber, double amount, String paymentMethod) {
        String confirmationNumber = "PAY-" + (System.currentTimeMillis() % 100000);
        return String.format("Payment Processed Successfully\n" +
               "=================================\n" +
               "Customer ID: %s\n" +
               "Policy Number: %s\n" +
               "Payment Amount: $%.2f\n" +
               "Payment Method: %s\n" +
               "Confirmation Number: %s\n" +
               "Transaction Date: %s\n" +
               "Next Payment Due: %s\n" +
               "Status: COMPLETED\n" +
               "Receipt sent to registered email address", 
               customerId, policyNumber, amount, paymentMethod, confirmationNumber,
               java.time.LocalDateTime.now(),
               java.time.LocalDate.now().plusMonths(1));
    }

    @Action(description = "Submit customer feedback")
    public String submitFeedback(String customerId, int rating, String comments) {
        String feedbackId = "FDB-" + (System.currentTimeMillis() % 100000);
        return String.format("Thank you for your feedback!\n" +
               "=================================\n" +
               "Feedback ID: %s\n" +
               "Customer ID: %s\n" +
               "Rating: %d/5 stars\n" +
               "Comments: %s\n" +
               "Submission Date: %s\n" +
               "Status: RECEIVED\n" +
               "Thank you for helping us improve our service!", 
               feedbackId, customerId, rating, comments,
               java.time.LocalDateTime.now());
    }

    @Action(description = "Check service availability")
    public String checkServiceStatus() {
        return "Insurance Services Status\n" +
               "=================================\n" +
               "Policy Management: OPERATIONAL\n" +
               "Claims Processing: OPERATIONAL\n" +
               "Underwriting: OPERATIONAL\n" +
               "Payment Gateway: OPERATIONAL\n" +
               "Customer Portal: OPERATIONAL\n" +
               "Phone Support: OPERATIONAL (24/7)\n" +
               "Email Support: OPERATIONAL (Response within 4 hours)\n" +
               "Live Chat: OPERATIONAL (9 AM - 6 PM EST)\n" +
               "Last Update: " + java.time.LocalDateTime.now();
    }

    @Action(description = "Get customer support options")
    public String getSupportOptions() {
        return "Customer Support Options\n" +
               "=================================\n\n" +
               "1. PHONE SUPPORT\n" +
               "   General Inquiries: 1-800-555-0100\n" +
               "   Claims: 1-800-555-0200\n" +
               "   Roadside Assistance: 1-800-555-0300\n" +
               "   Hours: 24/7\n\n" +
               "2. ONLINE SUPPORT\n" +
               "   Customer Portal: https://insurance.com/portal\n" +
               "   Live Chat: https://insurance.com/chat\n" +
               "   Email: support@insurance.com\n\n" +
               "3. MOBILE APP\n" +
               "   iOS: Download from App Store\n" +
               "   Android: Download from Google Play\n" +
               "   Features: Policy management, claims, payments\n\n" +
               "4. IN-PERSON\n" +
               "   Find an office: https://insurance.com/locations\n" +
               "   Schedule appointment required\n\n" +
               "5. EMERGENCY SUPPORT\n" +
               "   24/7 Emergency Claims: 1-800-555-9999";
    }
}
