package comLuz.processor.readings.application.create;

import comLuz.processor.readings.domain.ReadingPeriod;
import comLuz.processor.readings.domain.ReadingPeriodMother;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingClientIdMother;
import comLuz.processor.readings.domain.ReadingAmount;
import comLuz.processor.readings.domain.ReadingAmountMother;

public final class CreateReadingRequestMother {
	
	public static CreateReadingRequest create(ReadingClientId clientId, ReadingPeriod period, ReadingAmount amount) {
		
		return new CreateReadingRequest(clientId, period, amount);
		
	}

	public static CreateReadingRequest random() {
		
		return create (ReadingClientIdMother.random(), ReadingPeriodMother.random(), ReadingAmountMother.random());
		
	}
	
}