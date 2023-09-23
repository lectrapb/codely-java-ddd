package com.app.infraestructure.bus.event.mysql;

import com.app.infraestructure.bus.event.mysql.domain.DomainEventData;
import com.app.infraestructure.bus.event.mysql.infra.JPAEventBusRepository;
import lombok.AllArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
public class MySqlDomainEventsConsumer {

    private final JPAEventBusRepository eventBusRepository;

    private final Integer CHUNKS  = 200;

    @Transactional
    public void consume() {
        while (true) {


            var all = eventBusRepository.findAll();


        }
    }
}
