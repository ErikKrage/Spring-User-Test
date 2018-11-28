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
    private static TokenRepository tokenRepository;
    private static final String VERSION = "0.3.1";

    public static void main(String[] args) {
        // TODO poll current version and link to jar if necessary
        SpringApplication.run(SwarmApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(TokenRepository _repository) {
        tokenRepository = _repository;
        log.info("Token repository registered!");
        return (args) -> {
            _repository.save(new Token());
            _repository.save(new Token());
            _repository.save(new Token());
            _repository.save(new Token("Test access token value", TokenClass.ACCESS_TOKEN));
            _repository.save(new Token("Test session token value", TokenClass.SESSION_TOKEN));
            _repository.save(new Token("Test refresh token value", TokenClass.REFRESH_TOKEN));
            _repository.save(new Token("changed session token value", TokenClass.SESSION_TOKEN));
            log.info("Token dummy created.");
        };
    }

    public static TokenRepository getTokenRepository(){
        return tokenRepository;
    }
}
