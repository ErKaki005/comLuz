package comLuz.apps.processor.command;

import shared.comLuz.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import shared.comLuz.infrastructure.cli.ConsoleCommand;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {
    private final RabbitMqDomainEventsConsumer consumer;

    public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}
