package comLuz.processor.readings.domain;

import comLuz.processor.readings.application.create.CreateReadingRequest;

public final class ReadingMother {
    public static Reading create(ReadingClientId clientId, ReadingPeriod period, ReadingAmount amount) {
        return new Reading(clientId, period, amount);
    }

    public static Reading fromRequest(CreateReadingRequest request) {
        return create(
            ReadingClientIdMother.create(request.clientIdStr()),
            ReadingPeriodMother.create(request.periodStr()),
            ReadingAmountMother.create(request.amountInt())
        );
    }

    public static Reading random() {
        return create(ReadingClientIdMother.random(), ReadingPeriodMother.random(), ReadingAmountMother.random());
    }
}
