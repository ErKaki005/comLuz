package comLuz.processor.readings.domain;

import shared.comLuz.domain.WordMother;

public class ReadingPeriodMother {

    public static ReadingPeriod create(String value) {
        return new ReadingPeriod(value);
    }

    public static ReadingPeriod random() {
        return create(WordMother.random());
    }
	
	
}
