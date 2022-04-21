package comLuz.processor.readings.domain;

import shared.comLuz.domain.IntMother;

public final class ReadingAmountMother {

    public static ReadingAmount create(Integer value) {
        return new ReadingAmount(value);
    }

    public static ReadingAmount random() {
        return create(IntMother.random());
    }
	
}
