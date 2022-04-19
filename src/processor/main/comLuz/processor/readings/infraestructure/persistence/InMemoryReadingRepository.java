package comLuz.processor.readings.infraestructure.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.Service;
import shared.comLuz.domain.criteria.Criteria;

@Service
public final class InMemoryReadingRepository implements ReadingRepository{

	HashMap<ReadingClientId, Reading> readings = new HashMap <>();
	
	@Override
	public void save(Reading reading) {
				
		this.readings.put(reading.clientId(), reading);
		
	}
	
    public Optional<Reading> search(ReadingClientId clientId) {
        return Optional.ofNullable(readings.get(clientId));
    }

	@Override
	public List<Reading> matching(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
