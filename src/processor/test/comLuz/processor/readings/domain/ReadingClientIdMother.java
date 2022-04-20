package comLuz.processor.readings.domain;

import shared.comLuz.domain.UuidMother;

public class ReadingClientIdMother {

    public static ReadingClientId create(String value) {
        return new ReadingClientId(value);
    }

    public static ReadingClientId random() {
        return create(UuidMother.random());
    }
	
}
