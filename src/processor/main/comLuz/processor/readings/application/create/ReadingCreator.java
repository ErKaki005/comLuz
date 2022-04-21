package comLuz.processor.readings.application.create;


import org.springframework.beans.factory.annotation.Qualifier;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.Service;
import shared.comLuz.domain.bus.event.EventBus;

@Service
public final class ReadingCreator {
	
	private final ReadingRepository repository;
	private final EventBus eventBus;
	
	
	/*public ReadingCreator(@Qualifier("InMemoryReadingRepository") ReadingRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}*/

	public ReadingCreator(@Qualifier("MySqlReadingRepository") ReadingRepository repository, EventBus eventBus) {
		this.repository = repository;
		this.eventBus = eventBus;
	}
	
	public void create(CreateReadingRequest request) {
		
		Reading reading = Reading.create(request.clientId(), request.period(), request.amount()); 
						
		repository.save(reading);
		eventBus.publish(reading.pullDomainEvents());
		
	}

}
