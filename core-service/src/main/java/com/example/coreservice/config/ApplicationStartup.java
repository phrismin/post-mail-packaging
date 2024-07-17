package com.example.coreservice.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup  implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private AmqpAdmin rabbitAdmin;


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        rabbitAdmin.initialize();
    }
}
