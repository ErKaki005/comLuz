package comLuz.processor.readings.domain;

import shared.comLuz.domain.StringValueObject;

public final class ReadingDate extends StringValueObject{

    public ReadingDate(String value) {
        super(value);
    }
	
    private ReadingDate() {
        super("");
    }
    
}
