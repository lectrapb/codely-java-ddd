package com.app.domain.bus.query;

public interface QueryBus {

    <R> R ask(Query query) throws QueryNotRegisteredError;
}
