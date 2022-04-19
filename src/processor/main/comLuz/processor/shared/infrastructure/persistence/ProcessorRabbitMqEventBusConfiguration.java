package comLuz.processor.shared.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shared.comLuz.infraestructure.bus.event.mysql.MySqlEventBus;
import shared.comLuz.infraestructure.bus.event.rabbitmq.RabbitMqEventBus;
import shared.comLuz.infraestructure.bus.event.rabbitmq.RabbitMqPublisher;


@Configuration
public class ProcessorRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;

    public ProcessorRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher,
        @Qualifier("moocMysqlEventBus") MySqlEventBus failoverPublisher
    ) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus moocRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}
