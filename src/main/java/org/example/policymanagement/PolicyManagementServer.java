package org.example.policymanagement;

import io.github.vishalmysore.tools4ai.EnableAgent;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-policymanagement.properties")
@Log
public class PolicyManagementServer {
    public static void main(String[] args) {
        SpringApplication.run(PolicyManagementServer.class, args);
        log.info("Policy Management Server started successfully on port 7871");
    }
}
