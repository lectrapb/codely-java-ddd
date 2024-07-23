package com.app.infraestructure.bus.query;

import com.app.domain.bus.query.Query;
import com.app.domain.bus.query.QueryHandler;
import com.app.domain.bus.query.QueryNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public final  class QueryHandlersInformation {

    Map<Class<? extends Query>, Class<? extends QueryHandler>> indexedQueryHandlers;

    public QueryHandlersInformation() {
        Reflections reflections = new Reflections("com.app");
        Set<Class<? extends QueryHandler>> classes     = reflections.getSubTypesOf(QueryHandler.class);

        indexedQueryHandlers = formatHandlers(classes);
    }

    private Map<Class<? extends Query>, Class<? extends QueryHandler>> formatHandlers(
            Set<Class<? extends QueryHandler>> queryHandlers
    ) {
        Map<Class<? extends Query>, Class<? extends QueryHandler>> handlers = new HashMap<>();

        for (Class<? extends QueryHandler> handler : queryHandlers) {
            ParameterizedType paramType  = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Query> queryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }

    public Class<? extends QueryHandler> search(Class<? extends Query> queryClass) throws QueryNotRegisteredError {
        Class<? extends QueryHandler> queryHandlerClass = indexedQueryHandlers.get(queryClass);

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

}
