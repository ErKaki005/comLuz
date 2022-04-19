package comLuz.processor.readings.application.create;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingImport;
import comLuz.processor.readings.domain.ReadingRepository;

final class ReadingCreatorShould {

	@Test
	
	void save_a_valid_reading() throws Exception{
		
		ReadingRepository repository = mock (ReadingRepository.class);
		
		ReadingCreator creator = new ReadingCreator(repository);
		
		Reading reading = new Reading (new ReadingId("some-id"), new ReadingDate("some-fecha"), new ReadingImport( "some-importe"));
		
		creator.create(new CreateReadingRequest(reading.id(), reading.fecha(), reading.importe()));
		
		verify(repository, atLeastOnce()).save(reading);
		
	}
	
}
