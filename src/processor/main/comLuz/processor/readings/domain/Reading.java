package comLuz.processor.readings.domain;

import java.util.Objects;

import org.hibernate.annotations.Entity;

import shared.comLuz.domain.AggregateRoot;
import shared.comLuz.domain.reading.ReadingCreatedDomainEvent;

@Entity
public final class Reading extends AggregateRoot {


	private final ReadingClientId clientId;
	private final ReadingPeriod period;
	private final ReadingAmount amount;
	
	
	public Reading(ReadingClientId clientId, ReadingPeriod period, ReadingAmount amount) {
		this.clientId=clientId;
		this.period=period;
		this.amount=amount;
	}

	private Reading() {
		this.clientId=null;
		this.period=null;
		this.amount=null;
	}

	
    public static Reading create(ReadingClientId clientId, ReadingPeriod period, ReadingAmount amount) {
    	Reading reading = new Reading(clientId, period, amount);

    	reading.record(new ReadingCreatedDomainEvent(clientId.value(), period.value(), amount.value()));

        return reading;
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
				Objects.equals(amount, reading.amount()) &&
				Objects.equals(period, reading.period()) ;
		
	}
	
	
}
