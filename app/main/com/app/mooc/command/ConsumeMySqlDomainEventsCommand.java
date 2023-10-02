package com.app.mooc.command;

import com.app.infraestructure.bus.event.mysql.MySqlDomainEventsConsumer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ConsumeMySqlDomainEventsCommand {


    private final  MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

//    @Async
//    @Scheduled(fixedRate = 5000)
    public void execute(){

        consumer.consume();
    }


}
