package comLuz.processor.shared.infrastructure.persistence;



import java.util.Arrays;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "readings")
public final class Readings {

    @JacksonXmlElementWrapper(localName = "reading", useWrapping = false)
    private Reading[] reading;
	
	
    public Readings() {
    }

    public Readings(Reading[] reading) {
        this.reading = reading;
    }

    public Reading[] getReading() {
        return reading;
    }

    public void setReading(Reading[] reading) {
        this.reading = reading;
    }

    @Override 
    public String toString() {
        return "Readings{" +
                "Readings=" + Arrays.toString(reading) +
                '}';
    }
    
  

}
