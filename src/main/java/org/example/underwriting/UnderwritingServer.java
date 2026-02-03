package org.example.underwriting;

import io.github.vishalmysore.tools4ai.EnableAgent;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-underwriting.properties")
@Log
public class UnderwritingServer {
    public static void main(String[] args) {
        SpringApplication.run(UnderwritingServer.class, args);
        log.info("Underwriting Server started successfully on port 7873");
    }
}
