package org.example.claimsprocessing;

import io.github.vishalmysore.tools4ai.EnableAgent;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAgent
@PropertySource("classpath:application-claimsprocessing.properties")
@Log
public class ClaimsProcessingServer {
    public static void main(String[] args) {
        SpringApplication.run(ClaimsProcessingServer.class, args);
        log.info("Claims Processing Server started successfully on port 7872");
    }
}
