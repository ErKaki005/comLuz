package comLuz.processor.readings.domain;

import shared.comLuz.domain.StringValueObject;

public final class ReadingPeriod extends StringValueObject{

    public ReadingPeriod(String value) {
        super(value);
    }
	
    private ReadingPeriod() {
        super("");
    }
    
}
