package org.example.customerservice;

import io.github.vishalmysore.tools4ai.EnableAgent;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-customerservice.properties")
@Log
public class CustomerServiceServer {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceServer.class, args);
        log.info("Customer Service Server started successfully on port 7874");
    }
}
