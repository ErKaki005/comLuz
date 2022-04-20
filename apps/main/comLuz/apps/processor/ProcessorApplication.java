package comLuz.apps.processor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import comLuz.apps.processor.command.ConsumeFileRecordsCommand;
import comLuz.apps.processor.command.ConsumeMySqlDomainEventsCommand;
import comLuz.apps.processor.command.ConsumeRabbitMqDomainEventsCommand;
import shared.comLuz.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"comLuz.processor.*","comLuz.apps.*","shared.comLuz.*"}
)
public class ProcessorApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
        	put("API", ConsumeFileRecordsCommand.class);
        }};
    }
}
