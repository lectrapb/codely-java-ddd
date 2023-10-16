package com.app.domain.bus.command;

public interface CommandBus {

    void dispatch(Command command) throws CommandNotRegisteredError;
}
