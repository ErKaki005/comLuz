package comLuz.processor.readings.application.create;


import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.Service;

@Service
public final class ReadingCreator {
	
	private ReadingRepository repository;
	
	
	public ReadingCreator(ReadingRepository repository) {
		this.repository = repository;
	}

	public void create(CreateReadingRequest request) {
		
		Reading reading = new Reading(request.clientId(), request.fecha(), request.importe());
		
		repository.save(reading);
		
	}

}
