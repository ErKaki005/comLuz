package comLuz.processor.readings.application.create;

import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingDateMother;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingIdMother;
import comLuz.processor.readings.domain.ReadingImport;
import comLuz.processor.readings.domain.ReadingImportMother;

public final class CreateReadingRequestMother {
	
	public static CreateReadingRequest create(ReadingId id, ReadingDate fecha, ReadingImport importe) {
		
		return new CreateReadingRequest(id, fecha, importe);
		
	}

	public static CreateReadingRequest random() {
		
		return create (ReadingIdMother.random(), ReadingDateMother.random(), ReadingImportMother.random());
		
	}
	
}