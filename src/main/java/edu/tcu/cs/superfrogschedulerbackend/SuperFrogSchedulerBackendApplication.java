package edu.tcu.cs.superfrogschedulerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SuperFrogSchedulerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperFrogSchedulerBackendApplication.class, args);
    }

}
