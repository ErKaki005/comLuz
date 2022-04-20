package shared.comLuz.insfrastructure;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;

import comLuz.processor.readings.application.create.CreateReadingRequest;
import shared.comLuz.domain.UuidGenerator;

public abstract class UnitTestCase {

    protected CreateReadingRequest request;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
    	request      = mock(CreateReadingRequest.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldGenerateUuid(String uuid) {
        when(uuidGenerator.generate()).thenReturn(uuid);
    }

    public void shouldGenerateUuids(String uuid, String... others) {
        when(uuidGenerator.generate()).thenReturn(uuid, others);
    }

}
