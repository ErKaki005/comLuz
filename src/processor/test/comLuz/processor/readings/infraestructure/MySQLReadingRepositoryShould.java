package comLuz.processor.readings.infraestructure;

import org.junit.jupiter.api.Test;

import comLuz.processor.readings.ReadingsModuleInfrastructureTestCase;
import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingClientIdMother;
import comLuz.processor.readings.domain.ReadingMother;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
final class MySQLReadingRepositoryShould extends ReadingsModuleInfrastructureTestCase {

    @Test
    void save_a_reading() {
        Reading reading = ReadingMother.random();

        mySqlReadingRepository.save(reading);
    }

    @Test
    void return_an_existing_reading() {
    	Reading reading = ReadingMother.random();

    	mySqlReadingRepository.save(reading);

        assertEquals(Optional.of(reading), mySqlReadingRepository.search(reading.clientId()));
    }

    @Test
    void not_return_a_non_existing_reading() {
        assertFalse(mySqlReadingRepository.search(ReadingClientIdMother.random()).isPresent());
    }
}
