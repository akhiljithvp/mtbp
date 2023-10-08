package com.mtbp.ticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@ComponentScan(
    {
        "com.mtbp.commons.*",
        "com.mtbp.db.*",
        "com.mtbp.ticketing.*"
    }
)
@EnableMongoRepositories(
    basePackages = {
        "com.mtbp.db.repositories"
    }
)
public class TicketingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingServiceApplication.class, args);
    }

}
