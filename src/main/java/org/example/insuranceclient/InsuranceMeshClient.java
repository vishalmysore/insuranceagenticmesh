package org.example.insuranceclient;


import io.github.vishalmysore.mesh.AgentCatalog;
import io.github.vishalmysore.mesh.AgenticMesh;
import lombok.extern.java.Log;

/**
 * Insurance Mesh Client demonstrating integration of multiple insurance domain agents
 */
@Log
public class InsuranceMeshClient {
    public static void main(String[] args) {
        log.info("Initializing Insurance Agentic Mesh...");
        
        AgentCatalog agentCatalog = new AgentCatalog();
        
        // Add all insurance domain agents to the mesh
        agentCatalog.addAgent("http://localhost:7871/"); // Policy Management Server
        agentCatalog.addAgent("http://localhost:7872/"); // Claims Processing Server
        agentCatalog.addAgent("http://localhost:7873/"); // Underwriting Server
        agentCatalog.addAgent("http://localhost:7874/"); // Customer Service Server
        
        log.info("Insurance Mesh initialized with 4 specialized agents");
        
        // Example: Complex insurance workflow
        System.out.println("\n=== Insurance Mesh Demo ===\n");
        
        // 1. Get customer information
        String customerInfo = agentCatalog.processQuery("Get customer account information for customer ID CUST-12345")
            .getTextResult();
        System.out.println("Customer Information:\n" + customerInfo);
        
        // 2. Assess risk for new policy
        String riskAssessment = agentCatalog.processQuery(
            "Assess risk for John Doe, 42 years old, good health, software engineer, non-smoker")
            .getTextResult();
        System.out.println("\nRisk Assessment:\n" + riskAssessment);
        
        // 3. Create a policy
        String policyResult = agentCatalog.processQuery(
            "Create a life insurance policy for John Doe with $500,000 coverage")
            .getTextResult();
        System.out.println("\nPolicy Creation:\n" + policyResult);
        
        // 4. Submit a claim
        String claimResult = agentCatalog.processQuery(
            "Submit a medical claim for policy POL-12345, claim amount $5000, for emergency surgery")
            .getTextResult();
        System.out.println("\nClaim Submission:\n" + claimResult);
        
        // Complex cross-domain query
        String complexQuery = agentCatalog.processQuery(
            "For customer CUST-12345, check their active policies, assess if they need additional coverage, " +
            "and show any pending claims")
            .getTextResult();
        System.out.println("\nComplex Query Result:\n" + complexQuery);
        
        log.info("Insurance Mesh demo completed");

        AgenticMesh agenticMesh = new AgenticMesh(agentCatalog);


         complexQuery = agentCatalog.processQuery(
                        "For customer CUST-12345, check their active policies, assess if they need additional coverage, " +
                                "and show any pending claims")
                .getTextResult();
        System.out.println("\nComplex Query Result:\n" + complexQuery);
        complexQuery= agenticMesh.pipeLineMesh("For customer CUST-12345, check their active policies, assess if they need additional coverage, " +
                "and show any pending claims").getTextResult();
        System.out.println("\nComplex Query Result:\n" + complexQuery);

        log.info("Insurance Mesh demo completed");

    }
}
