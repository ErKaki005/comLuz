package comLuz.apps.processor.controller.readings;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import comLuz.processor.readings.application.create.CreateReadingRequest;
import comLuz.processor.readings.application.create.ReadingCreator;
import comLuz.processor.readings.domain.ReadingDate;
import comLuz.processor.readings.domain.ReadingId;
import comLuz.processor.readings.domain.ReadingImport;


@RestController
public final class ReadingsPutController {
    
		private ReadingCreator creator;
	
	public ReadingsPutController(ReadingCreator  creator) {
        this.creator= creator;
	}
	
    @PutMapping(value = "/readings/{id}")
    public ResponseEntity<String> index( @PathVariable String id, @RequestBody Request request ){ 
    	
    	    	
    	creator.create(new CreateReadingRequest(new ReadingId(id), 
				new ReadingDate(request.fecha()), 
				new ReadingImport(request.importe())));
        return new ResponseEntity<>(HttpStatus.CREATED);
        
    }

}

final class Request {
    private String fecha;
    private String importe;

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    String fecha() {
        return fecha;
    }

    String importe() {
        return importe;
    }
}