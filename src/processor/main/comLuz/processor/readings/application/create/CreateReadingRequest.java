package comLuz.processor.readings.application.create;

import java.util.Objects;

import comLuz.processor.readings.domain.ReadingPeriod;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingAmount;


public final class CreateReadingRequest {

	private final ReadingClientId clientId;
	private final ReadingAmount amount;
	private final ReadingPeriod period;
	
	public CreateReadingRequest (ReadingClientId clientId, ReadingPeriod period, ReadingAmount amount) {
		this.clientId=clientId;
		this.period=period;
		this.amount=amount;
		
	}
	
	public ReadingClientId clientId() {
		return clientId;
	}

	public ReadingAmount amount() {
		return amount;
	}


	public ReadingPeriod period() {
		return period;
	}
	
	public String clientIdStr() {
		return clientId.value();
	}

	public Integer amountInt() {
		return amount.value();
	}


	public String periodStr() {
		return period.value();
	}
	
	@Override
	public boolean equals(Object o){
		
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof CreateReadingRequest)) {
			return false;
		}
		
		CreateReadingRequest createReadingRequest = (CreateReadingRequest) o;
		
		return Objects.equals(clientId, createReadingRequest.clientId()) &&
				Objects.equals(amount, createReadingRequest.amount()) &&
				Objects.equals(period, createReadingRequest.period()) ;
		
	}
	
}
