package com.mtbp.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(
    {
        "com.mtbp.commons.*",
        "com.mtbp.db.*",
        "com.mtbp.movies.*"
    }
)
@EnableMongoRepositories(
    basePackages = {
        "com.mtbp.db.repositories"
    }
)
@EnableMongoAuditing
public class MovieServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication.class, args);
    }

}
