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
    private static UserRepository globalUserRepository;
    private static CompanyRepository globalCompanyRepository;
    private static final String VERSION = "0.3.1";

    public static void main(String[] args) {
        // TODO poll current version and link to jar if necessary
        SpringApplication.run(SwarmApplication.class, args);
        System.out.println();
    }

    @Bean
    public CommandLineRunner init(UserRepository _repositoryUser) {
        globalUserRepository = _repositoryUser;
        log.info("User repository registered!");
        return (args) -> {
            _repositoryUser.save(new User());
            log.info("User dummy created.");
        };
    }

    @Bean
    public CommandLineRunner initCompanies(CompanyRepository _repositoryCompany){
        globalCompanyRepository = _repositoryCompany;
        log.info("Company repository registered!");
        return (args) -> {
            _repositoryCompany.save(new Company());
            log.info("Company dummy created.");
        };
    }

    public static UserRepository getGlobalUserRepository(){
        return globalUserRepository;
    }

    public static CompanyRepository getGlobalCompanyRepository(){
        return globalCompanyRepository;
    }
}
