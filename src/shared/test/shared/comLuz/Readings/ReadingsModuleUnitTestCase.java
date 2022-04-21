package shared.comLuz.Readings;

import org.junit.jupiter.api.BeforeEach;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.bus.event.EventBus;
import shared.comLuz.insfrastructure.UnitTestCase;

import static org.mockito.Mockito.*;


public abstract class ReadingsModuleUnitTestCase extends UnitTestCase{

	protected ReadingRepository repository;
	protected EventBus eventBus;

    @BeforeEach
    protected void setUp() {

    	repository = mock(ReadingRepository.class);
    	eventBus = mock(EventBus.class);
    }

    public void shouldHaveSaved(Reading reading) {
        verify(repository, atLeastOnce()).save(reading);
    }
   
    
}
