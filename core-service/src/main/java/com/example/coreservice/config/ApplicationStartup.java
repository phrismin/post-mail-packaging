package com.example.coreservice.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup  implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private AmqpAdmin rabbitAdmin;

    @Override
    public void onApplicationEvent(@NotNull final ApplicationReadyEvent event) {
        rabbitAdmin.initialize();
    }
}
