package comLuz.apps.processor.controller.health_check;

import org.junit.jupiter.api.Test;

import comLuz.apps.processor.ProcessorApplicationTestCase;


final class HealthCheckGetControllerShould extends ProcessorApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}
