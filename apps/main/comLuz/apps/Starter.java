package comLuz.apps;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import comLuz.apps.processor.ProcessorApplication;
import shared.comLuz.domain.Service;
import shared.comLuz.infrastructure.cli.ConsoleCommand;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
	    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
	    value = {"comLuz.apps.*","comLuz.processor.*","shared.comLuz.*"}
	)

public class Starter {

	public static void main(String[] args) {
		
        if (args.length < 3) {
            throw new RuntimeException("There are not enough arguments");
        }
		
		String applicationName = args[0];
		String commandName = args[1];
		
	    ensureApplicationExist(applicationName);
	    ensureCommandExist(applicationName, commandName);
		
		
		Class<?> applicationClass = applications().get(applicationName);
		SpringApplication app = new SpringApplication(applicationClass);
		app.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context = app.run(args);
		
		ConsoleCommand command = (ConsoleCommand) context.getBean(commands().get(applicationName).get(commandName));

        command.execute(Arrays.copyOfRange(args, 2, args.length));
        
	}
	
	
    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                "The application <%s> doesn't exist. Valids:\n- %s",
                applicationName,
                String.join("\n- ", applications().keySet())
            ));
        }
    }

    private static void ensureCommandExist(String applicationName, String commandName) {
        if (!"server".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(String.format(
                "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                commandName,
                applicationName,
                String.join("\n- ", commands().get(applicationName).keySet())
            ));
        }
    }
    
    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("processor", ProcessorApplication.class);
        
        return applications;
    }
    
    private static HashMap<String, HashMap<String, Class<?>>> commands() {
        HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();

        commands.put("processor", ProcessorApplication.commands());

        return commands;
    }
    
    private static Boolean existCommand(String applicationName, String commandName) {
        HashMap<String, HashMap<String, Class<?>>> commands = commands();

        return commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName);
    }
    
}
