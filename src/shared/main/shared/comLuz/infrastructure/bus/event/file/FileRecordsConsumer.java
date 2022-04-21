package shared.comLuz.infrastructure.bus.event.file;

import org.springframework.beans.factory.annotation.Autowired;

import comLuz.processor.readings.application.create.CreateReadingRequest;
import comLuz.processor.readings.application.create.ReadingCreator;
import comLuz.processor.readings.domain.ReadingAmount;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingPeriod;
import comLuz.processor.readings.infraestructure.persistence.MySqlReadingRepository;
import shared.comLuz.domain.Service;


@Service
public final class FileRecordsConsumer {

	@Autowired
	private ReadingCreator creator;
	@Autowired
	private MySqlReadingRepository repository;
	
	
	
    public void consume(String client, String periodo, String importe) {
    	
    	ReadingClientId clientId = new ReadingClientId(client);
    	ReadingPeriod period = new ReadingPeriod(periodo);
    	ReadingAmount amount = new ReadingAmount(Integer.parseInt(importe));
    	
    	CreateReadingRequest request = new CreateReadingRequest(clientId, period, amount);

    	creator.create(request);
		

    	
    }


}
