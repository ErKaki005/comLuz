package comLuz.processor.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shared.comLuz.infrastructure.bus.event.DomainEventsInformation;
import shared.comLuz.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import shared.comLuz.infrastructure.bus.event.mysql.MySqlEventBus;
import shared.comLuz.infrastructure.bus.event.spring.SpringApplicationEventBus;


@Configuration
public class ProcessorMySqlEventBusConfiguration {
    private final SessionFactory            sessionFactory;
    private final DomainEventsInformation   domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public ProcessorMySqlEventBusConfiguration(
        @Qualifier("processor-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.sessionFactory          = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus                     = bus;
    }

    @Bean
    public MySqlEventBus processorMysqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer processorMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}
