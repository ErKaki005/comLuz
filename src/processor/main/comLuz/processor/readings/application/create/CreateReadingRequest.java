package comLuz.processor.readings.application.create;

import java.util.Objects;

import comLuz.processor.readings.domain.ReadingPeriod;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingAmount;


public final class CreateReadingRequest {

	private final ReadingClientId clientId;
	private final ReadingAmount importe;
	private final ReadingPeriod fecha;
	
	public CreateReadingRequest (ReadingClientId clientId, ReadingPeriod fecha, ReadingAmount importe) {
		this.clientId=clientId;
		this.fecha=fecha;
		this.importe=importe;
		
	}
	
	public ReadingClientId clientId() {
		return clientId;
	}

	public ReadingAmount importe() {
		return importe;
	}


	public ReadingPeriod fecha() {
		return fecha;
	}
	
	public String clientIdStr() {
		return clientId.value();
	}

	public Integer importeInt() {
		return importe.value();
	}


	public String fechaStr() {
		return fecha.value();
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
				Objects.equals(importe, createReadingRequest.importe()) &&
				Objects.equals(fecha, createReadingRequest.fecha()) ;
		
	}
	
}
