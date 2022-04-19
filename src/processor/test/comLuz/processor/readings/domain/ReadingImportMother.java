package comLuz.processor.readings.domain;

import shared.comLuz.domain.IntMother;

public final class ReadingImportMother {

    public static ReadingImport create(Integer value) {
        return new ReadingImport(value);
    }

    public static ReadingImport random() {
        return create(IntMother.random());
    }
	
}
