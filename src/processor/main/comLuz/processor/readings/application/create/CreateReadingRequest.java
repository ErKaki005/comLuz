package comLuz.processor.readings.application.create;

import java.util.Objects;

import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingImport;


public final class CreateReadingRequest {

	private final ReadingId id;
	private final ReadingImport importe;
	private final ReadingDate fecha;
	
	public CreateReadingRequest (ReadingId id, ReadingDate fecha, ReadingImport importe) {
		this.id=id;
		this.fecha=fecha;
		this.importe=importe;
		
	}
	
	public ReadingId id() {
		return id;
	}

	public ReadingImport importe() {
		return importe;
	}


	public ReadingDate fecha() {
		return fecha;
	}
	
	public String idStr() {
		return id.value();
	}

	public Integer importeStr() {
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
		
		return Objects.equals(id, createReadingRequest.id()) &&
				Objects.equals(importe, createReadingRequest.importe()) &&
				Objects.equals(fecha, createReadingRequest.fecha()) ;
		
	}
	
}
