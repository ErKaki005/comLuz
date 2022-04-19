package comLuz.processor.readings.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingMother;
import shared.comLuz.Readings.ReadingsModuleUnitTestCase;

final class ReadingCreatorShould extends ReadingsModuleUnitTestCase{

	private ReadingCreator creator;
	
	@BeforeEach
	
	protected void setUp() {
		super.setUp();
		
		creator =  new ReadingCreator(repository);
	}
	
	
	
	@Test
	
	void save_a_valid_reading() throws Exception{
		
	
		CreateReadingRequest request = CreateReadingRequestMother.random();
		
		Reading reading = ReadingMother.fromRequest(request);
		
		creator.create(request);
		
		shouldHaveSaved(reading);
		
	}
	
}
