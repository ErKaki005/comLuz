package comLuz.processor.readings.domain;

import shared.comLuz.domain.WordMother;

public class ReadingDateMother {

    public static ReadingDate create(String value) {
        return new ReadingDate(value);
    }

    public static ReadingDate random() {
        return create(WordMother.random());
    }
	
	
}
