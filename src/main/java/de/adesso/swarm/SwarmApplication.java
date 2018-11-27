package de.adesso.swarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwarmApplication {

    private static final Logger log = LoggerFactory.getLogger(SwarmApplication.class);
    private static UserRepository global_repository;

    public static void main(String[] args) {
        SpringApplication.run(SwarmApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UserRepository repository) {
        global_repository = repository;
        log.info("Repository registered!");
        return (args) -> {
            repository.save(new User());
            log.info("Dummy created.");
        };
    }

    public static UserRepository getGlobal_repository(){
        return global_repository;
    }
}
