package comLuz.processor.readings.domain;

import java.util.List;
import java.util.Optional;

import shared.comLuz.domain.criteria.Criteria;


public interface ReadingRepository {
    
	void save(Reading reading);
	
	Optional<Reading> search(ReadingClientId clientId);
    
	List<Reading> matching(Criteria criteria);
}
