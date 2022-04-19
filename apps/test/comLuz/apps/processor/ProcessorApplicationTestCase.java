package comLuz.apps.processor;

import org.springframework.transaction.annotation.Transactional;

import comLuz.apps.ApplicationTestCase;

@Transactional("processor-transaction_manager")
public abstract class ProcessorApplicationTestCase extends ApplicationTestCase {
}
