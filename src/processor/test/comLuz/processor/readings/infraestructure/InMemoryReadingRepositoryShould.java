package comLuz.processor.readings.infraestructure;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingDateMother;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingImportMother;

final class InMemoryReadingRepositoryShould {
	
	@Test
	public void save_a_valid_reading() {
		
		InMemoryReadingRepository repository = new InMemoryReadingRepository();
		
		repository.save(new Reading(new ReadingId("some-id"),ReadingDateMother.random(), ReadingImportMother.random()));
		
	}
	
	@Test
	
	public void search_an_existing_reading() {
	
		InMemoryReadingRepository repository = new InMemoryReadingRepository();
		
		Reading reading = new Reading(new ReadingId("some-id"),ReadingDateMother.random(), ReadingImportMother.random());
		
		repository.save(reading);
		
		Assert.assertEquals(Optional.of(reading), repository.search(reading.id()));
	
	}

	
	@Test
	
	public void search_a_non_existing_reading() {
	
		InMemoryReadingRepository repository = new InMemoryReadingRepository();
		
		Reading reading = new Reading(new ReadingId("some-id"),ReadingDateMother.random(), ReadingImportMother.random());
		
		repository.save(reading);
		
		Assert.assertFalse(repository.search(new ReadingId("some-non-existing-id")).isPresent());
	
	}
	
}
