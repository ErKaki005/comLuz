package comLuz.processor.readings.domain;

import shared.comLuz.domain.WordMother;

public final class ReadingImportMother {

    public static ReadingImport create(String value) {
        return new ReadingImport(value);
    }

    public static ReadingImport random() {
        return create(WordMother.random());
    }
	
}
