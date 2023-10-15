package com.app.mooc.command;


import com.app.infraestructure.bus.event.rabbit.RabbitMqDomainEventsConsumer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeRabbitMqDomainEventsCommand implements ApplicationListener {

   private final RabbitMqDomainEventsConsumer consumer;

    public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if(event instanceof ApplicationReadyEvent){
            consumer.consume();
        }

    }

}
