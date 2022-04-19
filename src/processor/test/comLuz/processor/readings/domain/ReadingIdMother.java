package comLuz.processor.readings.domain;

import shared.comLuz.domain.UuidMother;

public class ReadingIdMother {

    public static ReadingId create(String value) {
        return new ReadingId(value);
    }

    public static ReadingId random() {
        return create(UuidMother.random());
    }
	
}
