package comLuz.processor.readings.application.create;

import java.util.Objects;

import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingImport;


public final class CreateReadingRequest {

	private final ReadingClientId clientId;
	private final ReadingImport importe;
	private final ReadingDate fecha;
	
	public CreateReadingRequest (ReadingClientId clientId, ReadingDate fecha, ReadingImport importe) {
		this.clientId=clientId;
		this.fecha=fecha;
		this.importe=importe;
		
	}
	
	public ReadingClientId clientId() {
		return clientId;
	}

	public ReadingImport importe() {
		return importe;
	}


	public ReadingDate fecha() {
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
