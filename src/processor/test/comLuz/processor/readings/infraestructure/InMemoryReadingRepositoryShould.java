package comLuz.processor.readings.infraestructure;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import comLuz.processor.readings.ReadingsModuleInfraestructureTestCase;
import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingMother;
import comLuz.processor.readings.infraestructure.persistence.InMemoryReadingRepository;
import shared.comLuz.domain.UuidMother;

final class InMemoryReadingRepositoryShould extends ReadingsModuleInfraestructureTestCase {
	
	@Test
	public void save_a_valid_reading() {
		
		Reading reading = ReadingMother.random();
		
		repository.save(reading);
		
	}
	
	@Test
	
	public void search_an_existing_reading() {
	
		InMemoryReadingRepository repository = new InMemoryReadingRepository();
		
		Reading reading = ReadingMother.random();
		
		repository.save(reading);
		
		Assert.assertEquals(Optional.of(reading), repository.search(reading.id()));
	
	}

	
	@Test
	
	public void search_a_non_existing_reading() {
	
		InMemoryReadingRepository repository = new InMemoryReadingRepository();
		
		Reading reading = ReadingMother.random();
		
		repository.save(reading);
		
		Assert.assertFalse(repository.search(new ReadingId(UuidMother.random())).isPresent());
	
	}
	
}
