package dev.lucasmachado.config;

import dev.lucasmachado.services.EmailService;
import dev.lucasmachado.services.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }

}
