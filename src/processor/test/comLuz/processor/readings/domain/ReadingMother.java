package comLuz.processor.readings.domain;

import comLuz.processor.readings.application.create.CreateReadingRequest;

public final class ReadingMother {
    public static Reading create(ReadingId id, ReadingDate fecha, ReadingImport importe) {
        return new Reading(id, fecha, importe);
    }

    public static Reading fromRequest(CreateReadingRequest request) {
        return create(
            ReadingIdMother.create(request.idStr()),
            ReadingDateMother.create(request.fechaStr()),
            ReadingImportMother.create(request.importeStr())
        );
    }

    public static Reading random() {
        return create(ReadingIdMother.random(), ReadingDateMother.random(), ReadingImportMother.random());
    }
}
