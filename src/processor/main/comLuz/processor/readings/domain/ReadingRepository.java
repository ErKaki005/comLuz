package comLuz.processor.readings.domain;

import java.util.Optional;


public interface ReadingRepository {
    
	void save(Reading reading);
	
	Optional<Reading> search(ReadingId id);
        
}
