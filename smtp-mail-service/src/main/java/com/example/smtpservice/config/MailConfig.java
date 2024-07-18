package com.example.smtpservice.config;

import jakarta.mail.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Properties;

public class MailConfig {

    @Bean
    public Session session() {
        return Session.getDefaultInstance(smptProperties());
    }

    @Bean
    @Primary
    public Properties smptProperties() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }
}
