package shared.comLuz.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;

import shared.comLuz.domain.Service;
import shared.comLuz.domain.bus.command.Command;
import shared.comLuz.domain.bus.command.CommandBus;
import shared.comLuz.domain.bus.command.CommandHandler;
import shared.comLuz.domain.bus.command.CommandHandlerExecutionError;


@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
