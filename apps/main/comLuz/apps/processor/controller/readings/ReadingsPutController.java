package comLuz.apps.processor.controller.readings;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comLuz.processor.readings.application.create.CreateReadingRequest;
import comLuz.processor.readings.application.create.ReadingCreator;
import comLuz.processor.readings.domain.ReadingPeriod;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingAmount;


@RestController
public final class ReadingsPutController {
    
		private ReadingCreator creator;
	
	public ReadingsPutController(ReadingCreator  creator) {
        this.creator= creator;
	}
	
    @PutMapping(value = "/readings/{id}")
    public ResponseEntity<String> index( @PathVariable String ClientId, @RequestBody Request request ){ 
    	
    	    	
    	creator.create(new CreateReadingRequest(new ReadingClientId(ClientId), 
				new ReadingPeriod(request.period()), 
				new ReadingAmount(request.amount())));
        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }

}

final class Request {
    private String period;
    private Integer amount;

    public void setAmount(Integer importe) {
        this.amount = importe;
    }

    public void setperiod(String period) {
        this.period = period;
    }

    String period() {
        return period;
    }

    Integer amount() {
        return amount;
    }
}
