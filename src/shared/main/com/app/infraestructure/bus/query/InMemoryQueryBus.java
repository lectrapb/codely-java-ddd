package com.app.infraestructure.bus.query;

import com.app.domain.bus.query.*;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InMemoryQueryBus implements QueryBus {

    private final QueryHandlersInformation information;
    private final ApplicationContext context;
    @Override
    public Response ask(Query query) throws QueryNotRegisteredError {
        Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

        QueryHandler handler = context.getBean(queryHandlerClass);

        return handler.handle(query);
    }
}
