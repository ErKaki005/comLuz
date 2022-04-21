package comLuz.processor.readings.domain;

import shared.comLuz.domain.IntValueObject;

public final class ReadingAmount extends IntValueObject{

    public ReadingAmount(Integer value) {
        super(value);
    }
    
    private ReadingAmount() {
    	super(0);
    }

}
