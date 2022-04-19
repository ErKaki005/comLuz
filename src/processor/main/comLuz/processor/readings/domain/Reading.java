package comLuz.processor.readings.domain;

import java.util.Objects;

public final class Reading {


	private final ReadingId id;
	private final ReadingDate fecha;
	private final ReadingImport importe;
	
	
	public Reading(ReadingId id, ReadingDate fecha, ReadingImport importe) {
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


	@Override
	public boolean equals(Object o){
		
		if (this == o) {
			return true;
		}
		
		if (!(o instanceof Reading)) {
			return false;
		}
		
		Reading reading = (Reading) o;
		
		return Objects.equals(id, reading.id()) &&
				Objects.equals(importe, reading.importe()) &&
				Objects.equals(fecha, reading.fecha()) ;
		
	}
	
	
}
