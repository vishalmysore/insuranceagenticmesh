# Building Cutting-Edge Agentic Mesh Systems in Java: Transform Your Existing Code into Multi-Agent AI Architecture Using A2A Java Library

## Table of Contents
1. [Introduction to Agentic Mesh Architecture](#introduction)
2. [Understanding the Insurance Agentic Mesh](#insurance-mesh)
3. [Core Components and Architecture](#architecture)
4. [A2A Java Library: AgentCatalog and AgenticMesh](#a2a-library)
5. [Converting Existing Java Code to Agentic Architecture](#implementation)
6. [Advanced Agentic Mesh Concepts](#advanced-concepts)
7. [Real-World Use Cases](#use-cases)
8. [Performance and Scalability](#performance)
9. [Security and Compliance](#security)
10. [Best Practices and Design Patterns](#best-practices)

---

## Introduction to Agentic Mesh Architecture {#introduction}

### What is an Agentic Mesh?

An **Agentic Mesh** is a cutting-edge distributed architecture pattern where multiple specialized AI agents collaborate autonomously to solve complex, domain-specific problems. Unlike traditional monolithic systems, an agentic mesh enables agents to:

- **Operate independently** with specific domain expertise
- **Communicate seamlessly** using standardized protocols (MCP, A2A)
- **Scale horizontally** by adding new specialized agents
- **Maintain loose coupling** while ensuring high cohesion
- **Self-organize** to handle complex workflows
- **Transform legacy code** into intelligent, collaborative agents

### Why Transform Your Java Code into Agentic Mesh?

The insurance industry presents unique challenges that make it an ideal candidate for demonstrating agentic mesh architecture:

- **Complex workflows** spanning policy management, claims, underwriting, and customer service
- **Domain expertise** that can be encapsulated in specialized agents
- **Existing Java codebases** that can be easily converted to agents
- **Modular architecture** enabling incremental migration from monolithic systems
- **AI-powered decision making** without completely rewriting your applications

---

## Understanding the Insurance Agentic Mesh {#insurance-mesh}

### System Overview

This Insurance Agentic Mesh implementation showcases a cutting-edge distributed system built with Java, demonstrating how to transform traditional service-oriented code into four specialized AI agents:

```
┌─────────────────────────────────────────────────────────────┐
│                    Insurance Mesh Client                     │
│                  (AgentCatalog + AgenticMesh)               │
└────────────────────┬────────────────────────────────────────┘
                     │
        ┌────────────┼────────────┬────────────┐
        │            │            │            │
        ▼            ▼            ▼            ▼
    ┌───────┐  ┌────────┐  ┌──────────┐  ┌──────────┐
    │Policy │  │Claims  │  │Under-    │  │Customer  │
    │Mgmt   │  │Process │  │writing   │  │Service   │
    │:7871  │  │:7872   │  │:7873     │  │:7874     │
    └───────┘  └────────┘  └──────────┘  └──────────┘
```

### Agent Responsibilities

#### 1. Policy Management Agent (Port 7871)
**Domain**: Complete policy lifecycle management

**Key Capabilities**:
- Policy creation, renewal, and cancellation
- Premium calculation with multi-factor analysis
- Policy details retrieval and updates
- Customer policy portfolio management

```java
@Agent(groupName = "policyManagementOperations")
@Service
public class PolicyManagementService {
    
    @Action(description = "Create a new insurance policy")
    public String createPolicy(String policyType, String customerName, 
                               double coverageAmount) {
        String policyNumber = "POL-" + (System.currentTimeMillis() % 100000);
        return String.format("Policy created successfully!\n" +
               "Policy Number: %s\n" +
               "Policy Type: %s\n" +
               "Customer: %s\n" +
               "Coverage Amount: $%.2f\n" +
               "Status: ACTIVE", 
               policyNumber, policyType, customerName, coverageAmount);
    }
    
    @Action(description = "Calculate premium for a policy")
    public String calculatePremium(String policyType, int age, 
                                   double coverageAmount, String riskCategory) {
        double basePremium = coverageAmount * 0.0025;
        double ageFactor = age > 50 ? 1.5 : 1.0;
        double riskFactor = riskCategory.equalsIgnoreCase("HIGH") ? 2.0 : 
                           riskCategory.equalsIgnoreCase("MEDIUM") ? 1.3 : 1.0;
        double totalPremium = basePremium * ageFactor * riskFactor;
        
        return String.format("Annual Premium: $%.2f\nMonthly: $%.2f", 
                           totalPremium, totalPremium / 12);
    }
}
```

#### 2. Claims Processing Agent (Port 7872)
**Domain**: End-to-end claims management

**Key Capabilities**:
- Claim submission and validation
- Status tracking and updates
- Approval/denial workflows
- Payment processing
- Documentation management

```java
@Agent(groupName = "claimsProcessingOperations")
@Service
public class ClaimsProcessingService {
    
    @Action(description = "Submit a new insurance claim")
    public String submitClaim(String policyNumber, String claimType, 
                             double claimAmount, String description) {
        String claimNumber = "CLM-" + (System.currentTimeMillis() % 100000);
        return String.format("Claim submitted successfully!\n" +
               "Claim Number: %s\n" +
               "Status: PENDING REVIEW\n" +
               "Expected Processing: 5-7 business days", claimNumber);
    }
    
    @Action(description = "Calculate claim payout amount")
    public String calculateClaimPayout(String claimNumber, double claimAmount, 
                                       double deductible, double coveragePercentage) {
        double payoutAmount = (claimAmount - deductible) * (coveragePercentage / 100.0);
        return String.format("Final Payout Amount: $%.2f", Math.max(0, payoutAmount));
    }
}
```

#### 3. Underwriting Agent (Port 7873)
**Domain**: Risk assessment and pricing

**Key Capabilities**:
- Multi-factor risk analysis
- Premium rate calculation
- Eligibility evaluation
- Risk report generation
- Application approval/denial

```java
@Agent(groupName = "underwritingOperations")
@Service
public class UnderwritingService {
    
    @Action(description = "Assess risk for an insurance application")
    public String assessRisk(String applicantName, int age, 
                            String healthStatus, String occupation, boolean smoker) {
        int riskScore = 50;
        
        // Multi-factor risk calculation
        if (age > 60) riskScore += 30;
        else if (age > 45) riskScore += 15;
        
        if (healthStatus.equalsIgnoreCase("EXCELLENT")) riskScore -= 20;
        else if (healthStatus.equalsIgnoreCase("POOR")) riskScore += 30;
        
        if (smoker) riskScore += 25;
        
        String riskCategory = riskScore < 40 ? "LOW" : 
                             riskScore < 70 ? "MEDIUM" : "HIGH";
        
        return String.format("Risk Score: %d/100\nCategory: %s", 
                           riskScore, riskCategory);
    }
}
```

#### 4. Customer Service Agent (Port 7874)
**Domain**: Customer support and account management

**Key Capabilities**:
- Account information retrieval
- Customer inquiry handling
- Appointment scheduling
- Document generation
- Payment processing

```java
@Agent(groupName = "customerServiceOperations")
@Service
public class CustomerServiceService {
    
    @Action(description = "Handle customer inquiry")
    public String handleInquiry(String customerId, String inquiryType, 
                                String question) {
        String response;
        switch (inquiryType.toLowerCase()) {
            case "policy":
                response = "Your policy information retrieved. " +
                          "You have 3 active policies.";
                break;
            case "claim":
                response = "Please provide your claim number for status.";
                break;
            default:
                response = "A representative will respond within 24 hours.";
        }
        return String.format("Ticket: TKT-%d\nResponse: %s", 
                           System.currentTimeMillis() % 100000, response);
    }
}
```

---

## Core Components and Architecture {#architecture}

### Technology Stack

```xml
<dependencies>
    <!-- Spring Boot for REST APIs -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.2.4</version>
    </dependency>
    
    <!-- A2A Java Library - Core Agentic Mesh -->
    <dependency>
        <groupId>io.github.vishalmysore</groupId>
        <artifactId>a2ajava</artifactId>
        <version>1.0.7</version>
    </dependency>
    
    <!-- Tools4AI - Agent Action Framework -->
    <dependency>
        <groupId>io.github.vishalmysore</groupId>
        <artifactId>tools4ai</artifactId>
        <version>1.1.9.7</version>
    </dependency>
    
    <!-- Tools4AI Annotations -->
    <dependency>
        <groupId>io.github.vishalmysore</groupId>
        <artifactId>tools4ai-annotations</artifactId>
        <version>0.0.2</version>
    </dependency>
</dependencies>
```

### Configuration Architecture

Each agent server uses Spring profiles for isolation:

**application-policymanagement.properties**:
```properties
server.port=7871
spring.application.name=policy-management-server
```

**tools4ai_policymanagement.properties**:
```properties
agent.provider=openai
gemini.modelName=gemini-2.0-flash-001
anthropic.modelName=claude-3-haiku-20240307
openAiModelName=nvidia/nemotron-nano-12b-v2-vl
```

### Server Bootstrap

Each agent runs as an independent Spring Boot application:

```java
@SpringBootApplication
public class PolicyManagementServer {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "policymanagement");
        SpringApplication.run(PolicyManagementServer.class, args);
    }
}
```

---

## A2A Java Library: AgentCatalog and AgenticMesh {#a2a-library}

### Understanding AgentCatalog

**AgentCatalog** is the foundational component of the A2A Java library that enables agent discovery and communication. It acts as a registry and coordinator for all agents in the mesh.

#### Key Features:
- **Agent Registration**: Dynamic addition of agent endpoints
- **Query Routing**: Intelligent routing of queries to appropriate agents
- **Load Balancing**: Distribution of requests across agents
- **Fault Tolerance**: Handling agent failures gracefully
- **Protocol Support**: MCP (Model Context Protocol) and A2A (Agent-to-Agent)

#### Basic Usage:

```java
import io.github.vishalmysore.mesh.AgentCatalog;

public class BasicAgentCatalogExample {
    public static void main(String[] args) {
        // Create AgentCatalog instance
        AgentCatalog catalog = new AgentCatalog();
        
        // Register agents by endpoint URL
        catalog.addAgent("http://localhost:7871/"); // Policy Management
        catalog.addAgent("http://localhost:7872/"); // Claims Processing
        catalog.addAgent("http://localhost:7873/"); // Underwriting
        catalog.addAgent("http://localhost:7874/"); // Customer Service
        
        // Execute queries - catalog routes to appropriate agent
        String result = catalog.processQuery(
            "Create a life insurance policy for John Doe with $500,000 coverage"
        ).getTextResult();
        
        System.out.println(result);
    }
}
```

#### Advanced AgentCatalog Features:

```java
public class AdvancedAgentCatalogExample {
    public void demonstrateAdvancedFeatures() {
        AgentCatalog catalog = new AgentCatalog();
        
        // Add agents with metadata
        catalog.addAgent("http://localhost:7871/");
        catalog.addAgent("http://localhost:7872/");
        
        // Multi-agent query - catalog determines which agents to use
        String complexResult = catalog.processQuery(
            "For customer CUST-12345, check active policies, " +
            "assess risk for additional coverage, and show pending claims"
        ).getTextResult();
        
        // The catalog automatically:
        // 1. Parses the complex query
        // 2. Identifies required agents (Policy, Underwriting, Claims)
        // 3. Routes sub-queries to appropriate agents
        // 4. Aggregates responses
        // 5. Returns unified result
        
        System.out.println(complexResult);
    }
}
```

### Understanding AgenticMesh

**AgenticMesh** builds on top of AgentCatalog to provide advanced orchestration capabilities, including pipeline processing, parallel execution, and complex workflow management.

#### Key Features:
- **Pipeline Processing**: Sequential agent execution with context passing
- **Parallel Execution**: Concurrent agent invocation for performance
- **Workflow Orchestration**: Complex multi-step processes
- **Context Management**: Shared state across agent interactions
- **Error Handling**: Comprehensive error recovery mechanisms

#### Basic Usage:

```java
import io.github.vishalmysore.mesh.AgentCatalog;
import io.github.vishalmysore.mesh.AgenticMesh;

public class BasicAgenticMeshExample {
    public static void main(String[] args) {
        // Initialize catalog and mesh
        AgentCatalog catalog = new AgentCatalog();
        catalog.addAgent("http://localhost:7871/");
        catalog.addAgent("http://localhost:7872/");
        catalog.addAgent("http://localhost:7873/");
        catalog.addAgent("http://localhost:7874/");
        
        AgenticMesh mesh = new AgenticMesh(catalog);
        
        // Pipeline execution - agents execute in sequence
        String pipelineResult = mesh.pipeLineMesh(
            "Create policy for John Doe, assess risk, calculate premium"
        ).getTextResult();
        
        System.out.println(pipelineResult);
    }
}
```

### Complete Client Implementation Example

Here's the full implementation from the Insurance Mesh project:

```java
package org.example.insuranceclient;

import io.github.vishalmysore.mesh.AgentCatalog;
import io.github.vishalmysore.mesh.AgenticMesh;
import lombok.extern.java.Log;

@Log
public class InsuranceMeshClient {
    public static void main(String[] args) {
        log.info("Initializing Insurance Agentic Mesh...");
        
        // Step 1: Create AgentCatalog
        AgentCatalog agentCatalog = new AgentCatalog();
        
        // Step 2: Register all insurance domain agents
        agentCatalog.addAgent("http://localhost:7871/"); // Policy Management
        agentCatalog.addAgent("http://localhost:7872/"); // Claims Processing
        agentCatalog.addAgent("http://localhost:7873/"); // Underwriting
        agentCatalog.addAgent("http://localhost:7874/"); // Customer Service
        
        log.info("Insurance Mesh initialized with 4 specialized agents");
        
        // Step 3: Execute individual queries via AgentCatalog
        System.out.println("\n=== AgentCatalog Examples ===\n");
        
        // Query 1: Customer information
        String customerInfo = agentCatalog.processQuery(
            "Get customer account information for customer ID CUST-12345"
        ).getTextResult();
        System.out.println("Customer Information:\n" + customerInfo);
        
        // Query 2: Risk assessment
        String riskAssessment = agentCatalog.processQuery(
            "Assess risk for John Doe, 42 years old, good health, " +
            "software engineer, non-smoker"
        ).getTextResult();
        System.out.println("\nRisk Assessment:\n" + riskAssessment);
        
        // Query 3: Policy creation
        String policyResult = agentCatalog.processQuery(
            "Create a life insurance policy for John Doe with $500,000 coverage"
        ).getTextResult();
        System.out.println("\nPolicy Creation:\n" + policyResult);
        
        // Query 4: Claim submission
        String claimResult = agentCatalog.processQuery(
            "Submit a medical claim for policy POL-12345, " +
            "claim amount $5000, for emergency surgery"
        ).getTextResult();
        System.out.println("\nClaim Submission:\n" + claimResult);
        
        // Query 5: Complex cross-domain query
        String complexQuery = agentCatalog.processQuery(
            "For customer CUST-12345, check their active policies, " +
            "assess if they need additional coverage, and show any pending claims"
        ).getTextResult();
        System.out.println("\nComplex Query Result:\n" + complexQuery);
        
        // Step 4: Create AgenticMesh for pipeline processing
        AgenticMesh agenticMesh = new AgenticMesh(agentCatalog);
        
        System.out.println("\n=== AgenticMesh Pipeline Examples ===\n");
        
        // Pipeline query - sequential execution with context passing
        String pipelineResult = agenticMesh.pipeLineMesh(
            "For customer CUST-12345, check their active policies, " +
            "assess if they need additional coverage, and show any pending claims"
        ).getTextResult();
        System.out.println("\nPipeline Result:\n" + pipelineResult);
        
        log.info("Insurance Mesh demo completed");
    }
}
```

### AgentCatalog vs AgenticMesh: When to Use What

| Feature | AgentCatalog | AgenticMesh |
|---------|--------------|-------------|
| **Use Case** | Simple queries, agent discovery | Complex workflows, pipelines |
| **Execution Model** | Intelligent routing | Sequential/parallel orchestration |
| **Context Sharing** | Limited | Full context passing |
| **Performance** | Faster for single queries | Optimized for multi-step |
| **Complexity** | Low | Medium to High |

**Use AgentCatalog when:**
- Making single agent calls
- Simple query routing needed
- Low latency requirements
- Independent operations

**Use AgenticMesh when:**
- Multi-step workflows required
- Context must be passed between agents
- Complex orchestration needed
- Pipeline processing required

---

## Converting Existing Java Code to Agentic Architecture {#implementation}

### Transforming a Traditional Service into an Agent

The beauty of the A2A Java library is that it allows you to convert your existing Java services into intelligent agents with minimal code changes. Let's see how to transform traditional code into agentic architecture.

#### Before: Traditional Java Service

```java
package org.example.myservice;

import org.springframework.stereotype.Service;

@Service
public class TraditionalPolicyService {
    
    // Traditional service method
    public PolicyResponse createPolicy(String customerName, 
                                      String policyType, 
                                      double coverage) {
        // Your existing business logic
        Policy policy = new Policy();
        policy.setCustomerName(customerName);
        policy.setPolicyType(policyType);
        policy.setCoverage(coverage);
        policy.setStatus("ACTIVE");
        
        return new PolicyResponse(policy);
    }
    
    public double calculatePremium(Policy policy, int age) {
        // Your existing calculation logic
        double basePremium = policy.getCoverage() * 0.0025;
        double ageFactor = age > 50 ? 1.5 : 1.0;
        return basePremium * ageFactor;
    }
}
```

#### After: Agentic Service (Just Add Annotations!)

```java
package org.example.myservice;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;

// Add @Agent annotation - that's it!
@Agent(groupName = "policyOperations")
@Service
public class AgenticPolicyService {
    
    // Add @Action annotation to expose as agent capability
    @Action(description = "Create a new insurance policy for a customer")
    public String createPolicy(String customerName, 
                              String policyType, 
                              double coverage) {
        // Keep your existing business logic!
        Policy policy = new Policy();
        policy.setCustomerName(customerName);
        policy.setPolicyType(policyType);
        policy.setCoverage(coverage);
        policy.setStatus("ACTIVE");
        
        // Return as String for agent communication
        return String.format("Policy created: %s for %s with coverage $%.2f",
                           policy.getId(), customerName, coverage);
    }
    
    @Action(description = "Calculate insurance premium based on coverage and age")
    public String calculatePremium(double coverage, int age) {
        // Your existing calculation logic unchanged!
        double basePremium = coverage * 0.0025;
        double ageFactor = age > 50 ? 1.5 : 1.0;
        double premium = basePremium * ageFactor;
        
        return String.format("Premium calculated: $%.2f/year", premium);
    }
}
```

**Key Changes:**
1. Add `@Agent` annotation to your service class
2. Add `@Action` annotations to methods you want to expose
3. Convert return types to `String` for agent communication
4. Your business logic remains **unchanged**!

### Building Your First Agent Server from Scratch

#### Step 1: Create the Service with @Agent and @Action

```java
package org.example.myservice;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import org.springframework.stereotype.Service;

@Agent(groupName = "myServiceOperations")
@Service
public class MyService {
    
    @Action(description = "Process customer request")
    public String processRequest(String customerId, String requestType) {
        // Your business logic here
        return "Request processed for customer: " + customerId;
    }
    
    @Action(description = "Calculate quote")
    public String calculateQuote(String productType, double amount) {
        double quote = amount * 1.15; // Example calculation
        return String.format("Quote for %s: $%.2f", productType, quote);
    }
}
```

#### Step 2: Create the Server Bootstrap

```java
package org.example.myservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyServiceServer {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "myservice");
        SpringApplication.run(MyServiceServer.class, args);
    }
}
```

#### Step 3: Configure Server Properties

**application-myservice.properties**:
```properties
server.port=7875
spring.application.name=my-service-server
logging.level.com.t4a=DEBUG
```

**tools4ai_myservice.properties**:
```properties
agent.provider=openai
openAiKey=${OPENAI_API_KEY}
openAiModelName=gpt-4
```

#### Step 4: Build and Run

```bash
# Build the project
mvn clean package

# Run your server
java -cp target/classes org.example.myservice.MyServiceServer
```

#### Step 5: Test with curl

```bash
# Discover available tools
curl -H "Content-Type: application/json" \
-d '{"jsonrpc":"2.0","method":"tools/list","params":{},"id":1}' \
http://localhost:7875/

# Call an action
curl -H "Content-Type: application/json" \
-d '{
    "jsonrpc": "2.0",
    "method": "tools/call",
    "params": {
        "name": "processRequest",
        "arguments": {
            "provideAllValuesInPlainEnglish": "{\"customerId\":\"CUST-123\",\"requestType\":\"quote\"}"
        }
    },
    "id": 2
}' \
http://localhost:7875/
```

### Integrating Your Agent into the Mesh

```java
public class ExtendedInsuranceMesh {
    public static void main(String[] args) {
        AgentCatalog catalog = new AgentCatalog();
        
        // Add existing agents
        catalog.addAgent("http://localhost:7871/"); // Policy
        catalog.addAgent("http://localhost:7872/"); // Claims
        catalog.addAgent("http://localhost:7873/"); // Underwriting
        catalog.addAgent("http://localhost:7874/"); // Customer Service
        
        // Add your new agent
        catalog.addAgent("http://localhost:7875/"); // Your Service
        
        // Now your agent is part of the mesh
        String result = catalog.processQuery(
            "Process quote request for customer CUST-123 using my service"
        ).getTextResult();
        
        System.out.println(result);
    }
}
```

---

## Advanced Agentic Mesh Concepts {#advanced-concepts}

### 1. Hierarchical Agent Organization

Create specialized sub-meshes for complex domains:

```java
public class HierarchicalMeshExample {
    public void createHierarchicalMesh() {
        // Life Insurance Sub-Mesh
        AgentCatalog lifeInsuranceMesh = new AgentCatalog();
        lifeInsuranceMesh.addAgent("http://localhost:7881/"); // Life Policy
        lifeInsuranceMesh.addAgent("http://localhost:7882/"); // Life Claims
        lifeInsuranceMesh.addAgent("http://localhost:7883/"); // Life Underwriting
        
        // Auto Insurance Sub-Mesh
        AgentCatalog autoInsuranceMesh = new AgentCatalog();
        autoInsuranceMesh.addAgent("http://localhost:7891/"); // Auto Policy
        autoInsuranceMesh.addAgent("http://localhost:7892/"); // Auto Claims
        autoInsuranceMesh.addAgent("http://localhost:7893/"); // Auto Underwriting
        
        // Master Mesh coordinating sub-meshes
        AgentCatalog masterMesh = new AgentCatalog();
        // Add coordination logic here
    }
}
```

### 2. Dynamic Agent Discovery

Implement service discovery for dynamic mesh composition:

```java
public class DynamicMeshExample {
    private AgentCatalog catalog;
    private Set<String> registeredAgents = new HashSet<>();
    
    public void registerAgentDynamically(String agentUrl, String agentType) {
        if (!registeredAgents.contains(agentUrl)) {
            catalog.addAgent(agentUrl);
            registeredAgents.add(agentUrl);
            System.out.println("Registered new agent: " + agentType + 
                             " at " + agentUrl);
        }
    }
    
    public void discoverAndRegisterAgents() {
        // Integration with service discovery (Consul, Eureka, etc.)
        List<ServiceInstance> instances = discoveryClient.getInstances("insurance-agent");
        for (ServiceInstance instance : instances) {
            registerAgentDynamically(instance.getUri().toString(), 
                                   instance.getMetadata().get("agentType"));
        }
    }
}
```

### 3. Context-Aware Agent Selection

Implement intelligent agent selection based on query context:

```java
public class ContextAwareRoutingExample {
    private AgentCatalog catalog;
    
    public String processContextAwareQuery(String query, Map<String, Object> context) {
        // Analyze query intent
        String intent = analyzeIntent(query);
        
        // Select agents based on context
        if (context.containsKey("policyType") && 
            context.get("policyType").equals("life")) {
            // Route to life insurance specific agents
            return catalog.processQuery(query + " [LIFE_INSURANCE_CONTEXT]")
                         .getTextResult();
        } else if (context.containsKey("urgency") && 
                  (Boolean) context.get("urgency")) {
            // Route to high-priority agents
            return catalog.processQuery(query + " [URGENT]")
                         .getTextResult();
        }
        
        return catalog.processQuery(query).getTextResult();
    }
    
    private String analyzeIntent(String query) {
        // NLP-based intent classification
        return "CREATE_POLICY"; // Simplified example
    }
}
```

### 4. Agent Collaboration Patterns

#### Pattern 1: Sequential Pipeline

```java
public class SequentialPipelinePattern {
    public void executeSequentialWorkflow(AgenticMesh mesh) {
        // Each step depends on previous step's output
        String result = mesh.pipeLineMesh(
            "Step 1: Assess risk for applicant → " +
            "Step 2: Calculate premium based on risk → " +
            "Step 3: Create policy with calculated premium → " +
            "Step 4: Send confirmation to customer"
        ).getTextResult();
    }
}
```

#### Pattern 2: Parallel Scatter-Gather

```java
public class ParallelScatterGatherPattern {
    public void executeParallelWorkflow(AgentCatalog catalog) {
        // Execute multiple independent queries in parallel
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        List<Future<String>> futures = Arrays.asList(
            executor.submit(() -> catalog.processQuery(
                "Check customer credit score").getTextResult()),
            executor.submit(() -> catalog.processQuery(
                "Verify customer identity").getTextResult()),
            executor.submit(() -> catalog.processQuery(
                "Check existing policies").getTextResult()),
            executor.submit(() -> catalog.processQuery(
                "Assess risk profile").getTextResult())
        );
        
        // Gather results
        futures.forEach(future -> {
            try {
                String result = future.get();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        executor.shutdown();
    }
}
```

#### Pattern 3: Conditional Routing

```java
public class ConditionalRoutingPattern {
    public String executeConditionalWorkflow(AgentCatalog catalog, 
                                            String customerId) {
        // Step 1: Get customer tier
        String tierResult = catalog.processQuery(
            "Get customer tier for " + customerId
        ).getTextResult();
        
        // Step 2: Route based on tier
        if (tierResult.contains("PREMIUM")) {
            return catalog.processQuery(
                "Process premium customer request with priority handling"
            ).getTextResult();
        } else if (tierResult.contains("GOLD")) {
            return catalog.processQuery(
                "Process gold customer request with standard handling"
            ).getTextResult();
        } else {
            return catalog.processQuery(
                "Process standard customer request"
            ).getTextResult();
        }
    }
}
```

### 5. Error Handling and Resilience

```java
public class ResilientMeshExample {
    private AgentCatalog catalog;
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 1000;
    
    public String executeWithRetry(String query) {
        int attempts = 0;
        Exception lastException = null;
        
        while (attempts < MAX_RETRIES) {
            try {
                return catalog.processQuery(query).getTextResult();
            } catch (Exception e) {
                lastException = e;
                attempts++;
                System.err.println("Attempt " + attempts + " failed: " + 
                                 e.getMessage());
                
                if (attempts < MAX_RETRIES) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS * attempts);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
        
        throw new RuntimeException("Failed after " + MAX_RETRIES + 
                                 " attempts", lastException);
    }
    
    public String executeWithFallback(String query, String fallbackQuery) {
        try {
            return catalog.processQuery(query).getTextResult();
        } catch (Exception e) {
            System.err.println("Primary query failed, using fallback: " + 
                             e.getMessage());
            return catalog.processQuery(fallbackQuery).getTextResult();
        }
    }
}
```

### 6. Performance Monitoring and Metrics

```java
public class MonitoredMeshExample {
    private AgentCatalog catalog;
    private Map<String, AgentMetrics> metricsMap = new ConcurrentHashMap<>();
    
    public String executeWithMonitoring(String query) {
        long startTime = System.currentTimeMillis();
        String result = null;
        boolean success = false;
        
        try {
            result = catalog.processQuery(query).getTextResult();
            success = true;
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            recordMetrics(query, duration, success);
        }
    }
    
    private void recordMetrics(String query, long duration, boolean success) {
        String agentType = extractAgentType(query);
        AgentMetrics metrics = metricsMap.computeIfAbsent(
            agentType, k -> new AgentMetrics()
        );
        
        metrics.incrementTotalCalls();
        metrics.addDuration(duration);
        if (success) {
            metrics.incrementSuccessCount();
        } else {
            metrics.incrementFailureCount();
        }
    }
    
    public void printMetrics() {
        metricsMap.forEach((agent, metrics) -> {
            System.out.println("\nAgent: " + agent);
            System.out.println("Total Calls: " + metrics.getTotalCalls());
            System.out.println("Success Rate: " + metrics.getSuccessRate() + "%");
            System.out.println("Avg Duration: " + metrics.getAverageDuration() + "ms");
        });
    }
    
    private String extractAgentType(String query) {
        // Logic to determine which agent type handled the query
        return "POLICY_MANAGEMENT"; // Simplified
    }
}

class AgentMetrics {
    private AtomicLong totalCalls = new AtomicLong(0);
    private AtomicLong successCount = new AtomicLong(0);
    private AtomicLong failureCount = new AtomicLong(0);
    private List<Long> durations = Collections.synchronizedList(new ArrayList<>());
    
    public void incrementTotalCalls() { totalCalls.incrementAndGet(); }
    public void incrementSuccessCount() { successCount.incrementAndGet(); }
    public void incrementFailureCount() { failureCount.incrementAndGet(); }
    public void addDuration(long duration) { durations.add(duration); }
    
    public long getTotalCalls() { return totalCalls.get(); }
    public double getSuccessRate() {
        return (successCount.get() * 100.0) / totalCalls.get();
    }
    public double getAverageDuration() {
        return durations.stream().mapToLong(Long::longValue).average().orElse(0.0);
    }
}
```

---

## Real-World Use Cases {#use-cases}

### Use Case 1: New Customer Onboarding

```java
public class CustomerOnboardingWorkflow {
    private AgenticMesh mesh;
    
    public String onboardNewCustomer(CustomerApplication application) {
        StringBuilder workflow = new StringBuilder();
        
        // Step 1: Create customer account
        workflow.append("Create customer account for ")
                .append(application.getName())
                .append(" with email ")
                .append(application.getEmail());
        
        // Step 2: Assess risk
        workflow.append(" → Assess risk: age ")
                .append(application.getAge())
                .append(", health ")
                .append(application.getHealthStatus());
        
        // Step 3: Calculate premium
        workflow.append(" → Calculate premium for ")
                .append(application.getPolicyType())
                .append(" coverage $")
                .append(application.getCoverageAmount());
        
        // Step 4: Create policy
        workflow.append(" → Create policy if approved");
        
        // Step 5: Send welcome package
        workflow.append(" → Generate welcome documents and send");
        
        return mesh.pipeLineMesh(workflow.toString()).getTextResult();
    }
}
```

### Use Case 2: Claims Processing with Fraud Detection

```java
public class ClaimsProcessingWorkflow {
    private AgentCatalog catalog;
    
    public String processClaimWithFraudCheck(ClaimSubmission claim) {
        // Step 1: Validate policy
        String policyValidation = catalog.processQuery(
            "Verify policy " + claim.getPolicyNumber() + " is active and valid"
        ).getTextResult();
        
        if (!policyValidation.contains("ACTIVE")) {
            return "Claim denied: Policy not active";
        }
        
        // Step 2: Check claim history
        String claimHistory = catalog.processQuery(
            "Get claim history for policy " + claim.getPolicyNumber()
        ).getTextResult();
        
        // Step 3: Fraud detection analysis
        boolean suspiciousClaim = detectFraud(claim, claimHistory);
        
        if (suspiciousClaim) {
            // Route to manual review
            return catalog.processQuery(
                "Flag claim " + claim.getClaimNumber() + 
                " for manual fraud investigation"
            ).getTextResult();
        }
        
        // Step 4: Calculate payout
        String payout = catalog.processQuery(
            "Calculate claim payout for " + claim.getClaimNumber() +
            " amount " + claim.getClaimAmount()
        ).getTextResult();
        
        // Step 5: Approve and process payment
        return catalog.processQuery(
            "Approve and process payment for claim " + claim.getClaimNumber()
        ).getTextResult();
    }
    
    private boolean detectFraud(ClaimSubmission claim, String history) {
        // Fraud detection logic
        return claim.getClaimAmount() > 10000 && 
               history.contains("multiple recent claims");
    }
}
```

### Use Case 3: Policy Renewal with Upsell

```java
public class PolicyRenewalWorkflow {
    private AgenticMesh mesh;
    
    public String processRenewalWithUpsell(String policyNumber) {
        String workflow = String.format(
            "Get policy details for %s → " +
            "Assess if customer needs additional coverage → " +
            "Calculate renewal premium with any applicable discounts → " +
            "Generate personalized upsell recommendations → " +
            "Send renewal notice with recommendations → " +
            "Process renewal if customer accepts",
            policyNumber
        );
        
        return mesh.pipeLineMesh(workflow).getTextResult();
    }
}
```

### Use Case 4: Multi-Policy Quote Comparison

```java
public class QuoteComparisonWorkflow {
    private AgentCatalog catalog;
    private ExecutorService executor = Executors.newFixedThreadPool(3);
    
    public ComparisonResult compareMultiplePolicies(CustomerProfile customer) {
        // Request quotes in parallel
        Future<String> lifeFuture = executor.submit(() ->
            catalog.processQuery(
                "Calculate life insurance premium for " + customer.describe()
            ).getTextResult()
        );
        
        Future<String> autoFuture = executor.submit(() ->
            catalog.processQuery(
                "Calculate auto insurance premium for " + customer.describe()
            ).getTextResult()
        );
        
        Future<String> homeFuture = executor.submit(() ->
            catalog.processQuery(
                "Calculate home insurance premium for " + customer.describe()
            ).getTextResult()
        );
        
        try {
            ComparisonResult result = new ComparisonResult();
            result.setLifeQuote(lifeFuture.get());
            result.setAutoQuote(autoFuture.get());
            result.setHomeQuote(homeFuture.get());
            result.calculateBundleDiscount();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Quote comparison failed", e);
        }
    }
}
```

---

## Performance and Scalability {#performance}

### Horizontal Scaling Strategies

#### 1. Agent Replication

```java
public class ReplicatedAgentMesh {
    private AgentCatalog catalog;
    
    public void setupReplicatedAgents() {
        // Add multiple instances of same agent for load distribution
        catalog.addAgent("http://policy-server-1:7871/");
        catalog.addAgent("http://policy-server-2:7871/");
        catalog.addAgent("http://policy-server-3:7871/");
        
        catalog.addAgent("http://claims-server-1:7872/");
        catalog.addAgent("http://claims-server-2:7872/");
        
        // Catalog automatically distributes load across replicas
    }
}
```

#### 2. Regional Distribution

```java
public class GeographicallyDistributedMesh {
    private Map<String, AgentCatalog> regionalCatalogs = new HashMap<>();
    
    public void setupRegionalMeshes() {
        // US East Region
        AgentCatalog usEast = new AgentCatalog();
        usEast.addAgent("http://us-east-policy:7871/");
        usEast.addAgent("http://us-east-claims:7872/");
        regionalCatalogs.put("US_EAST", usEast);
        
        // US West Region
        AgentCatalog usWest = new AgentCatalog();
        usWest.addAgent("http://us-west-policy:7871/");
        usWest.addAgent("http://us-west-claims:7872/");
        regionalCatalogs.put("US_WEST", usWest);
        
        // Europe Region
        AgentCatalog europe = new AgentCatalog();
        europe.addAgent("http://eu-policy:7871/");
        europe.addAgent("http://eu-claims:7872/");
        regionalCatalogs.put("EUROPE", europe);
    }
    
    public String routeByRegion(String query, String customerRegion) {
        AgentCatalog catalog = regionalCatalogs.get(customerRegion);
        return catalog.processQuery(query).getTextResult();
    }
}
```

### Performance Optimization Techniques

#### 1. Query Caching

```java
public class CachedMeshExample {
    private AgentCatalog catalog;
    private Cache<String, String> queryCache = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .expireAfterWrite(10, TimeUnit.MINUTES)
        .build();
    
    public String executeWithCache(String query) {
        try {
            return queryCache.get(query, () -> 
                catalog.processQuery(query).getTextResult()
            );
        } catch (ExecutionException e) {
            throw new RuntimeException("Query execution failed", e);
        }
    }
}
```

#### 2. Connection Pooling

```java
public class ConnectionPooledMesh {
    private AgentCatalog catalog;
    private ExecutorService executorService;
    
    public void setupConnectionPool() {
        // Configure HTTP client with connection pooling
        int maxConnections = 200;
        int maxConnectionsPerRoute = 50;
        
        executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2
        );
        
        // Configure agent catalog with pooled connections
        // Implementation depends on underlying HTTP client
    }
}
```

#### 3. Asynchronous Processing

```java
public class AsyncMeshExample {
    private AgentCatalog catalog;
    
    public CompletableFuture<String> executeAsync(String query) {
        return CompletableFuture.supplyAsync(() ->
            catalog.processQuery(query).getTextResult()
        );
    }
    
    public void executeBatchAsync(List<String> queries) {
        List<CompletableFuture<String>> futures = queries.stream()
            .map(this::executeAsync)
            .collect(Collectors.toList());
        
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .thenAccept(v -> {
                futures.forEach(future -> {
                    try {
                        System.out.println("Result: " + future.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });
    }
}
```

### Monitoring and Observability

#### Distributed Tracing Integration

```java
public class TracedMeshExample {
    private AgentCatalog catalog;
    
    public String executeWithTracing(String query, String traceId) {
        Span span = tracer.buildSpan("mesh-query")
            .withTag("query", query)
            .withTag("trace.id", traceId)
            .start();
        
        try {
            long startTime = System.currentTimeMillis();
            String result = catalog.processQuery(query).getTextResult();
            long duration = System.currentTimeMillis() - startTime;
            
            span.setTag("duration.ms", duration);
            span.setTag("success", true);
            
            return result;
        } catch (Exception e) {
            span.setTag("error", true);
            span.setTag("error.message", e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
    }
}
```

---

## Security and Compliance {#security}

### Authentication and Authorization

```java
public class SecureMeshExample {
    private AgentCatalog catalog;
    
    public String executeWithAuth(String query, String apiKey, 
                                  String userRole) {
        // Validate API key
        if (!isValidApiKey(apiKey)) {
            throw new SecurityException("Invalid API key");
        }
        
        // Check authorization
        if (!isAuthorized(userRole, extractOperation(query))) {
            throw new SecurityException("Unauthorized operation");
        }
        
        // Add security context to query
        Map<String, String> securityContext = new HashMap<>();
        securityContext.put("user_role", userRole);
        securityContext.put("api_key_hash", hashApiKey(apiKey));
        
        return catalog.processQuery(
            query + " [SECURITY_CONTEXT: " + securityContext + "]"
        ).getTextResult();
    }
    
    private boolean isValidApiKey(String apiKey) {
        // Validate against secure storage
        return true; // Simplified
    }
    
    private boolean isAuthorized(String role, String operation) {
        // Role-based access control
        Map<String, Set<String>> permissions = Map.of(
            "ADMIN", Set.of("CREATE", "READ", "UPDATE", "DELETE"),
            "AGENT", Set.of("READ", "UPDATE"),
            "CUSTOMER", Set.of("READ")
        );
        return permissions.getOrDefault(role, Set.of())
                         .contains(operation);
    }
    
    private String extractOperation(String query) {
        if (query.toLowerCase().contains("create")) return "CREATE";
        if (query.toLowerCase().contains("update")) return "UPDATE";
        if (query.toLowerCase().contains("delete")) return "DELETE";
        return "READ";
    }
    
    private String hashApiKey(String apiKey) {
        // Hash for logging purposes
        return String.valueOf(apiKey.hashCode());
    }
}
```

### Data Encryption

```java
public class EncryptedMeshExample {
    private AgentCatalog catalog;
    private Cipher cipher;
    
    public String executeWithEncryption(String query, 
                                       SecretKey encryptionKey) {
        try {
            // Encrypt sensitive data in query
            String encryptedQuery = encryptQuery(query, encryptionKey);
            
            // Execute with encrypted data
            String encryptedResult = catalog.processQuery(encryptedQuery)
                                           .getTextResult();
            
            // Decrypt result
            return decryptResult(encryptedResult, encryptionKey);
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }
    
    private String encryptQuery(String query, SecretKey key) 
        throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(query.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }
    
    private String decryptResult(String encrypted, SecretKey key) 
        throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(
            Base64.getDecoder().decode(encrypted)
        );
        return new String(decrypted);
    }
}
```

### Audit Logging

```java
public class AuditedMeshExample {
    private AgentCatalog catalog;
    private AuditLogger auditLogger;
    
    public String executeWithAudit(String query, String userId, 
                                   String sessionId) {
        AuditEvent event = new AuditEvent();
        event.setTimestamp(Instant.now());
        event.setUserId(userId);
        event.setSessionId(sessionId);
        event.setQuery(sanitizeForLog(query));
        event.setAction("MESH_QUERY");
        
        try {
            String result = catalog.processQuery(query).getTextResult();
            event.setStatus("SUCCESS");
            event.setResultSummary(summarizeResult(result));
            return result;
        } catch (Exception e) {
            event.setStatus("FAILURE");
            event.setErrorMessage(e.getMessage());
            throw e;
        } finally {
            auditLogger.log(event);
        }
    }
    
    private String sanitizeForLog(String query) {
        // Remove sensitive data before logging
        return query.replaceAll("ssn=\\d{9}", "ssn=XXX-XX-XXXX")
                   .replaceAll("account=\\d+", "account=XXXXX");
    }
    
    private String summarizeResult(String result) {
        return result.length() > 200 ? 
               result.substring(0, 200) + "..." : result;
    }
}
```

### Compliance Features

```java
public class CompliantMeshExample {
    private AgentCatalog catalog;
    
    public String executeWithCompliance(String query, 
                                       ComplianceContext context) {
        // GDPR compliance - check data processing consent
        if (context.getRegulation().equals("GDPR")) {
            if (!hasDataProcessingConsent(context.getCustomerId())) {
                throw new ComplianceException(
                    "No data processing consent for customer"
                );
            }
        }
        
        // HIPAA compliance - check PHI access authorization
        if (context.getDataType().equals("PHI")) {
            if (!isAuthorizedForPHI(context.getUserId())) {
                throw new ComplianceException(
                    "Not authorized to access PHI"
                );
            }
        }
        
        // Execute with compliance tracking
        String result = catalog.processQuery(query).getTextResult();
        
        // Log for compliance audit trail
        logComplianceEvent(context, query, result);
        
        return result;
    }
    
    private boolean hasDataProcessingConsent(String customerId) {
        // Check consent database
        return true; // Simplified
    }
    
    private boolean isAuthorizedForPHI(String userId) {
        // Check authorization database
        return true; // Simplified
    }
    
    private void logComplianceEvent(ComplianceContext context, 
                                   String query, String result) {
        // Log to immutable audit trail
        ComplianceLog log = new ComplianceLog();
        log.setTimestamp(Instant.now());
        log.setRegulation(context.getRegulation());
        log.setUserId(context.getUserId());
        log.setCustomerId(context.getCustomerId());
        log.setAction(extractAction(query));
        log.setDataAccessed(extractDataTypes(result));
        // Persist log
    }
    
    private String extractAction(String query) {
        // Extract action type for compliance tracking
        return "DATA_ACCESS"; // Simplified
    }
    
    private List<String> extractDataTypes(String result) {
        // Classify data types accessed
        return List.of("PERSONAL_INFO", "FINANCIAL_INFO");
    }
}
```

---

## Best Practices and Design Patterns {#best-practices}

### 1. Agent Design Principles

#### Single Responsibility Principle
```java
// GOOD: Agent focused on single domain
@Agent(groupName = "policyOperations")
public class PolicyAgent {
    @Action(description = "Create policy")
    public String createPolicy(...) { }
    
    @Action(description = "Update policy")
    public String updatePolicy(...) { }
}

// AVOID: Agent with mixed responsibilities
@Agent(groupName = "everythingOperations")
public class GodAgent {
    public String createPolicy(...) { }
    public String processClaim(...) { }
    public String assessRisk(...) { }
    public String handleCustomerService(...) { }
}
```

#### Clear Action Definitions
```java
// GOOD: Clear, descriptive actions
@Action(description = "Calculate life insurance premium based on age, " +
                     "health status, coverage amount, and risk factors")
public String calculateLifeInsurancePremium(
    int applicantAge,
    String healthStatus,
    double coverageAmount,
    String riskCategory
) { }

// AVOID: Vague action descriptions
@Action(description = "Do calculation")
public String calculate(Object... params) { }
```

### 2. Error Handling Patterns

```java
public class RobustMeshClient {
    private AgentCatalog catalog;
    
    public Result executeRobust(String query) {
        Result result = new Result();
        
        try {
            // Validate input
            validateQuery(query);
            
            // Execute with timeout
            String response = executeWithTimeout(query, 30, TimeUnit.SECONDS);
            
            result.setSuccess(true);
            result.setData(response);
            
        } catch (ValidationException e) {
            result.setSuccess(false);
            result.setErrorType("VALIDATION_ERROR");
            result.setErrorMessage(e.getMessage());
            
        } catch (TimeoutException e) {
            result.setSuccess(false);
            result.setErrorType("TIMEOUT");
            result.setErrorMessage("Query execution timed out");
            
        } catch (AgentUnavailableException e) {
            result.setSuccess(false);
            result.setErrorType("AGENT_UNAVAILABLE");
            result.setErrorMessage("Required agent is not available");
            // Implement retry logic or fallback
            
        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorType("UNKNOWN_ERROR");
            result.setErrorMessage(e.getMessage());
            // Log for investigation
        }
        
        return result;
    }
    
    private void validateQuery(String query) throws ValidationException {
        if (query == null || query.trim().isEmpty()) {
            throw new ValidationException("Query cannot be empty");
        }
        if (query.length() > 10000) {
            throw new ValidationException("Query too long");
        }
    }
    
    private String executeWithTimeout(String query, long timeout, 
                                     TimeUnit unit) 
        throws TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() ->
            catalog.processQuery(query).getTextResult()
        );
        
        try {
            return future.get(timeout, unit);
        } catch (TimeoutException e) {
            future.cancel(true);
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
```

### 3. Configuration Management

```java
public class ConfigurableMesh {
    private AgentCatalog catalog;
    private MeshConfig config;
    
    public void initializeFromConfig(String configPath) {
        config = loadConfig(configPath);
        
        // Initialize catalog with configuration
        catalog = new AgentCatalog();
        
        // Register agents from configuration
        config.getAgents().forEach(agentConfig -> {
            catalog.addAgent(agentConfig.getUrl());
        });
        
        // Apply mesh-level settings
        applySettings(config.getSettings());
    }
    
    private MeshConfig loadConfig(String path) {
        // Load from YAML, JSON, or properties file
        return new MeshConfig(); // Simplified
    }
    
    private void applySettings(MeshSettings settings) {
        // Configure timeouts, retry policies, etc.
    }
}
```

### 4. Testing Strategies

#### Unit Testing Agents
```java
@SpringBootTest
public class PolicyServiceTest {
    @Autowired
    private PolicyManagementService policyService;
    
    @Test
    public void testCreatePolicy() {
        String result = policyService.createPolicy(
            "Life Insurance", "John Doe", 500000.0
        );
        
        assertNotNull(result);
        assertTrue(result.contains("Policy created successfully"));
        assertTrue(result.contains("POL-"));
    }
    
    @Test
    public void testCalculatePremium() {
        String result = policyService.calculatePremium(
            "Life", 45, 500000.0, "LOW"
        );
        
        assertNotNull(result);
        assertTrue(result.contains("Annual Premium"));
    }
}
```

#### Integration Testing Mesh
```java
@SpringBootTest
public class MeshIntegrationTest {
    private AgentCatalog catalog;
    
    @BeforeEach
    public void setup() {
        catalog = new AgentCatalog();
        catalog.addAgent("http://localhost:7871/");
        catalog.addAgent("http://localhost:7872/");
        catalog.addAgent("http://localhost:7873/");
        catalog.addAgent("http://localhost:7874/");
    }
    
    @Test
    public void testEndToEndWorkflow() {
        // Test complete workflow
        String result = catalog.processQuery(
            "Create life insurance policy for John Doe with $500,000 coverage, " +
            "assess risk, and calculate premium"
        ).getTextResult();
        
        assertNotNull(result);
        // Verify workflow completed successfully
    }
}
```

#### Mock Testing
```java
public class MockMeshTest {
    @Test
    public void testWithMockAgents() {
        AgentCatalog mockCatalog = mock(AgentCatalog.class);
        
        when(mockCatalog.processQuery(anyString()))
            .thenReturn(new QueryResult("Mock response"));
        
        // Test your client code with mocked mesh
        String result = mockCatalog.processQuery("test query")
                                   .getTextResult();
        
        assertEquals("Mock response", result);
        verify(mockCatalog, times(1)).processQuery("test query");
    }
}
```


*This article demonstrates a cutting-edge implementation of agentic mesh architecture in Java, showcasing how to transform existing Java code into intelligent, collaborative agent systems. The complete source code is available in this repository as a reference for building your own agentic applications.*