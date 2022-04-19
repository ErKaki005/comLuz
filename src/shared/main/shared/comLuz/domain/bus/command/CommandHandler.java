package shared.comLuz.domain.bus.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
