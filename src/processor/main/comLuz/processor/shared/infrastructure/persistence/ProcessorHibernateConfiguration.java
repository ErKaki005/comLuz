package comLuz.processor.shared.infrastructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import shared.comLuz.infraestructure.config.Parameter;
import shared.comLuz.infraestructure.config.ParameterNotExist;
import shared.comLuz.infraestructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class ProcessorHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "processor";

    public ProcessorHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("processor-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("processor-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("processor-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("DATABASE_HOST"),
            config.getInt("DATABASE_PORT"),
            config.get("DATABASE_NAME"),
            config.get("DATABASE_USER"),
            config.get("DATABASE_PASSWORD")
        );
    }
}
