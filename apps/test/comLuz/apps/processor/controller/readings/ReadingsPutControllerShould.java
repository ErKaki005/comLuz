package comLuz.apps.processor.controller.readings;

import org.junit.jupiter.api.Test;

import comLuz.apps.ApplicationTestCase;

public final class ReadingsPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/readings/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"Period\": \"2016-01\", \"Amount\": \"42451\"}",
            201
        );
    }
}
