package comLuz.processor.readings.domain;

import java.util.Objects;

public final class Reading {


	private final ReadingClientId clientId;
	private final ReadingPeriod fecha;
	private final ReadingAmount importe;
	
	
	public Reading(ReadingClientId clientId, ReadingPeriod fecha, ReadingAmount importe) {
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
