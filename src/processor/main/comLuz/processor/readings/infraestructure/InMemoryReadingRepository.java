package comLuz.processor.readings.infraestructure;

import java.util.HashMap;
import java.util.Optional;


import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.Service;

@Service
public final class InMemoryReadingRepository implements ReadingRepository{

	HashMap<ReadingId, Reading> readings = new HashMap <>();
	
	@Override
	public void save(Reading reading) {
				
		this.readings.put(reading.id(), reading);
		
	}
	
    public Optional<Reading> search(ReadingId id) {
        return Optional.ofNullable(readings.get(id));
    }

}
