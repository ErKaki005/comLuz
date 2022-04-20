package comLuz.apps;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import shared.comLuz.domain.Service;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	    value = {"comLuz.processor.*","comLuz.apps.*","shared.comLuz.*"}
	)

public class Starter implements CommandLineRunner{

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(Starter.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
		//SpringApplication.run(Starter.class, args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	    return  args -> {
	        System.out.println("Let's inspect the beans provided by Spring Boot:");
	        String[] beanNames = ctx.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }
	    };
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola que tal");
	}
	
}
