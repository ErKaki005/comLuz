package comLuz.processor.readings.application.create;

import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingDateMother;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingClientIdMother;
import comLuz.processor.readings.domain.ReadingImport;
import comLuz.processor.readings.domain.ReadingImportMother;

public final class CreateReadingRequestMother {
	
	public static CreateReadingRequest create(ReadingClientId clientId, ReadingDate fecha, ReadingImport importe) {
		
		return new CreateReadingRequest(clientId, fecha, importe);
		
	}

	public static CreateReadingRequest random() {
		
		return create (ReadingClientIdMother.random(), ReadingDateMother.random(), ReadingImportMother.random());
		
	}
	
}