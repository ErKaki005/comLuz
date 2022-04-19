package shared.comLuz.Readings;

import org.junit.jupiter.api.BeforeEach;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.insfrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class ReadingsModuleUnitTestCase extends UnitTestCase{

    protected ReadingRepository repository;

    @BeforeEach
    protected void setUp() {

    	repository = mock(ReadingRepository.class);
    
    }

    public void shouldHaveSaved(Reading reading) {
        verify(repository, atLeastOnce()).save(reading);
    }
	
}
