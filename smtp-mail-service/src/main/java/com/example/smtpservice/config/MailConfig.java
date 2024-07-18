package com.example.smtpservice.config;

import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.protocol}")
    private String protocol;



    @Bean
    @Primary
    public Properties smptProperties() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", protocol);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    @Bean
    public Session session() {
        return Session.getDefaultInstance(smptProperties());
    }
}