package comLuz.processor.readings.domain;

import comLuz.processor.readings.application.create.CreateReadingRequest;

public final class ReadingMother {
    public static Reading create(ReadingClientId clientId, ReadingPeriod fecha, ReadingAmount importe) {
        return new Reading(clientId, fecha, importe);
    }

    public static Reading fromRequest(CreateReadingRequest request) {
        return create(
            ReadingClientIdMother.create(request.clientIdStr()),
            ReadingDateMother.create(request.fechaStr()),
            ReadingImportMother.create(request.importeInt())
        );
    }

    public static Reading random() {
        return create(ReadingClientIdMother.random(), ReadingDateMother.random(), ReadingImportMother.random());
    }
}
