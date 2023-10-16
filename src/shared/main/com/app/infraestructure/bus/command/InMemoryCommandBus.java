package com.app.infraestructure.bus.command;

import com.app.domain.bus.command.Command;
import com.app.domain.bus.command.CommandBus;
import com.app.domain.bus.command.CommandHandler;
import com.app.domain.bus.command.CommandNotRegisteredError;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCommandBus implements CommandBus {

    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(Command command) throws CommandNotRegisteredError {

        Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

        CommandHandler handler = context.getBean(commandHandlerClass);

        handler.handle(command);

    }
}
