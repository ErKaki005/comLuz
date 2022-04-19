package comLuz.processor.readings.domain;

import java.util.Objects;

public final class Reading {


	private final ReadingClientId clientId;
	private final ReadingDate fecha;
	private final ReadingImport importe;
	
	
	public Reading(ReadingClientId clientId, ReadingDate fecha, ReadingImport importe) {
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


	@Override
	public boolean equals(Object o){
		
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Reading)) {
			return false;
		}
		
		Reading reading = (Reading) o;
		
		return Objects.equals(clientId, reading.clientId()) &&
				Objects.equals(importe, reading.importe()) &&
				Objects.equals(fecha, reading.fecha()) ;
		
	}
	
	
}
