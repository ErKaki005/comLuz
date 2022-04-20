package comLuz.processor.readings;

import org.springframework.beans.factory.annotation.Autowired;

import comLuz.processor.readings.infraestructure.persistence.InMemoryReadingRepository;
import shared.comLuz.insfrastructure.InfrastructureTestCase;

public abstract class ReadingsModuleInfraestructureTestCase extends InfrastructureTestCase{

	@Autowired
	protected InMemoryReadingRepository repository;
	
}
