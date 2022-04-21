package comLuz.processor.readings;

import org.springframework.beans.factory.annotation.Autowired;

import comLuz.processor.readings.infraestructure.persistence.InMemoryReadingRepository;
import comLuz.processor.readings.infraestructure.persistence.MySqlReadingRepository;
import shared.comLuz.insfrastructure.InfrastructureTestCase;

public abstract class ReadingsModuleInfrastructureTestCase extends InfrastructureTestCase{

	@Autowired
	protected InMemoryReadingRepository repository;
	
	@Autowired
    protected MySqlReadingRepository  mySqlReadingRepository;
	
}
