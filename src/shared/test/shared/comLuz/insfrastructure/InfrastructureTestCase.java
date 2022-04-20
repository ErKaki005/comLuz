package shared.comLuz.insfrastructure;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import comLuz.apps.processor.ProcessorApplication;

@ContextConfiguration(classes = ProcessorApplication.class)
@SpringBootTest

public abstract class InfrastructureTestCase {

}
