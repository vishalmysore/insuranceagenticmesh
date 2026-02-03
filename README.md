# Insurance Agentic Mesh: Comprehensive Insurance Domain Implementation

## Overview

This project implements an Agentic Mesh for insurance domain systems, demonstrating how multiple specialized AI agents work together to create a comprehensive insurance platform. The mesh consists of four core insurance components, each operating as an independent server while maintaining the ability to collaborate.

## Server Components

### 1. Policy Management Server (Port 7871)
**Purpose**: Complete policy lifecycle management

**Capabilities**:
- Create new insurance policies
- Renew existing policies
- Cancel or suspend policies
- Update policy details
- Query policy information
- Calculate premium amounts

**Example Usage**:
```java
@Action(description = "Create a new insurance policy")
public String createPolicy(String policyType, String customerName, double coverageAmount)
```

### 2. Claims Processing Server (Port 7872)
**Purpose**: Claims submission and processing

**Capabilities**:
- Submit new claims
- Track claim status
- Approve or deny claims
- Calculate claim amounts
- Request additional documentation
- Process claim payments

**Example Usage**:
```java
@Action(description = "Submit a new insurance claim")
public String submitClaim(String policyNumber, String claimType, double claimAmount)
```

### 3. Underwriting Server (Port 7873)
**Purpose**: Risk assessment and underwriting operations

**Capabilities**:
- Assess risk profiles
- Calculate premium rates
- Evaluate coverage eligibility
- Generate risk reports
- Approve or decline applications
- Set policy terms and conditions

**Example Usage**:
```java
@Action(description = "Assess risk for insurance application")
public String assessRisk(String applicantInfo, String policyType)
```

### 4. Customer Service Server (Port 7874)
**Purpose**: Customer support and account management

**Capabilities**:
- Handle customer inquiries
- Update customer information
- Provide policy details
- Schedule appointments
- Generate policy documents
- Manage customer accounts

**Example Usage**:
```java
@Action(description = "Get customer account information")
public String getCustomerAccount(String customerId)
```

## Architecture

### Technology Stack
- **Framework**: Spring Boot 3.2.4
- **Java Version**: 17
- **Protocols**: MCP (Model Context Protocol), A2A (Agent-to-Agent)
- **Communication**: JSON-RPC 2.0
- **Port Range**: 7871-7874

### Server Configuration
Each server runs independently with:
- Dedicated port assignment
- Spring profile-based configuration
- Domain-specific service layer
- Tools4AI integration

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Spring Boot 3.x

### Building the Project
```bash
mvn clean package
```

### Starting Individual Servers

**Policy Management Server**:
```bash
java -cp target/classes org.example.policymanagement.PolicyManagementServer
```

**Claims Processing Server**:
```bash
java -cp target/classes org.example.claimsprocessing.ClaimsProcessingServer
```

**Underwriting Server**:
```bash
java -cp target/classes org.example.underwriting.UnderwritingServer
```

**Customer Service Server**:
```bash
java -cp target/classes org.example.customerservice.CustomerServiceServer
```

## Using the Insurance Mesh

### Mesh Client Example
```java
AgentCatalog agentCatalog = new AgentCatalog();

// Connect all insurance agents
agentCatalog.addAgent("http://localhost:7871/"); // Policy Management
agentCatalog.addAgent("http://localhost:7872/"); // Claims Processing
agentCatalog.addAgent("http://localhost:7873/"); // Underwriting
agentCatalog.addAgent("http://localhost:7874/"); // Customer Service

// Execute complex insurance workflow
String result = agentCatalog.processQuery(
    "Create a life insurance policy for John Doe with $500,000 coverage, assess the risk, and provide premium quote"
).getTextResult();
```

## API Testing

### Tool Discovery
```bash
curl -H "Content-Type: application/json" `
-d '{"jsonrpc":"2.0","method":"tools/list","params":{},"id":1}' `
http://localhost:7871/
```

### Creating a Policy
```bash
curl -H "Content-Type: application/json" `
-d '{
    "jsonrpc": "2.0",
    "method": "tools/call",
    "params": {
        "name": "createPolicy",
        "arguments": {
            "provideAllValuesInPlainEnglish": "{\"policyType\":\"Life Insurance\",\"customerName\":\"John Doe\",\"coverageAmount\":500000}"
        }
    },
    "id": 2
}' `
http://localhost:7871/
```

### Submitting a Claim
```bash
curl -H "Content-Type: application/json" `
-d '{
    "jsonrpc": "2.0",
    "method": "tools/call",
    "params": {
        "name": "submitClaim",
        "arguments": {
            "provideAllValuesInPlainEnglish": "{\"policyNumber\":\"POL-12345\",\"claimType\":\"Medical\",\"claimAmount\":5000}"
        }
    },
    "id": 3
}' `
http://localhost:7872/
```

## Use Cases

### 1. Complete Policy Lifecycle
```
1. Assess risk for new applicant
2. Calculate premium rates
3. Create new policy
4. Provide customer with policy details
```

### 2. Claims Management
```
- Submit claim through customer service
- Process claim through claims server
- Verify policy details
- Calculate claim payout
- Update customer on claim status
```

### 3. Customer Onboarding
```
- Collect customer information
- Assess risk profile
- Generate policy quote
- Create policy upon approval
- Set up customer account
```

### 4. Policy Renewal
```
- Review existing policy
- Re-assess risk factors
- Calculate renewal premium
- Process renewal payment
- Update policy terms
```

## Integration with AI Platforms

### Claude Desktop Configuration
```json
{
  "mcpServers": {
    "policy-management": {
      "command": "java",
      "args": ["-jar", "mcp-connector-full.jar", "http://localhost:7871"],
      "timeout": 30000
    },
    "claims-processing": {
      "command": "java",
      "args": ["-jar", "mcp-connector-full.jar", "http://localhost:7872"],
      "timeout": 30000
    },
    "underwriting": {
      "command": "java",
      "args": ["-jar", "mcp-connector-full.jar", "http://localhost:7873"],
      "timeout": 30000
    },
    "customer-service": {
      "command": "java",
      "args": ["-jar", "mcp-connector-full.jar", "http://localhost:7874"],
      "timeout": 30000
    }
  }
}
```

## Benefits

1. **Domain Specialization**: Each agent focuses on specific insurance operations
2. **Scalability**: Add new insurance products or services without affecting existing systems
3. **Compliance**: Centralized policy and regulatory compliance management
4. **Customer Experience**: Seamless integration across all customer touchpoints
5. **Operational Efficiency**: Automated workflows reduce processing time

## Insurance Workflows Supported

- **New Business**: Risk assessment → Premium calculation → Policy creation
- **Claims Processing**: Claim submission → Verification → Approval → Payment
- **Policy Servicing**: Updates, cancellations, reinstatements
- **Customer Support**: Inquiries, document requests, account management
- **Underwriting**: Risk evaluation, pricing, policy terms determination

## Security & Compliance

- Implement authentication and authorization
- Use encryption for sensitive customer data
- Maintain audit logs for all transactions
- Comply with insurance regulations (HIPAA, state insurance laws)
- Implement data retention policies
- Secure API endpoints with rate limiting

## Future Enhancements

- Fraud detection agent
- Actuarial analysis agent
- Document management agent
- Payment processing agent
- Regulatory compliance agent
- Analytics and reporting agent

## Project Structure
```
insuracneagenticmesh/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── policymanagement/
│   │   │           │   ├── PolicyManagementServer.java
│   │   │           │   └── PolicyManagementService.java
│   │   │           ├── claimsprocessing/
│   │   │           │   ├── ClaimsProcessingServer.java
│   │   │           │   └── ClaimsProcessingService.java
│   │   │           ├── underwriting/
│   │   │           │   ├── UnderwritingServer.java
│   │   │           │   └── UnderwritingService.java
│   │   │           ├── customerservice/
│   │   │           │   ├── CustomerServiceServer.java
│   │   │           │   └── CustomerServiceService.java
│   │   │           └── insuranceclient/
│   │   │               └── InsuranceMeshClient.java
│   │   └── resources/
│   │       ├── application-policymanagement.properties
│   │       ├── application-claimsprocessing.properties
│   │       ├── application-underwriting.properties
│   │       ├── application-customerservice.properties
│   │       ├── tools4ai_policymanagement.properties
│   │       ├── tools4ai_claimsprocessing.properties
│   │       ├── tools4ai_underwriting.properties
│   │       └── tools4ai_customerservice.properties
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## License

This is a demonstration project for educational purposes.

## Contact

For questions or contributions, please refer to the main project documentation.
