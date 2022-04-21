package comLuz.processor.readings.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingCreatedDomainEventMother;
import comLuz.processor.readings.domain.ReadingMother;
import shared.comLuz.Readings.ReadingsModuleUnitTestCase;
import shared.comLuz.domain.reading.ReadingCreatedDomainEvent;

final class ReadingCreatorShould extends ReadingsModuleUnitTestCase{

	private ReadingCreator creator;
	
	@BeforeEach
	
	protected void setUp() {
		super.setUp();
		creator =  new ReadingCreator(repository, eventBus);
	}
	
	
	
	@Test
	
	void save_a_valid_reading() throws Exception{
		
	
		CreateReadingRequest request = CreateReadingRequestMother.random();
		
		Reading reading = ReadingMother.fromRequest(request);
		
		ReadingCreatedDomainEvent domainEvent = ReadingCreatedDomainEventMother.fromReading(reading);
		
		creator.create(request);
		
		shouldHaveSaved(reading);
		//shouldHavePublished(domainEvent);
		
	}
	
}
