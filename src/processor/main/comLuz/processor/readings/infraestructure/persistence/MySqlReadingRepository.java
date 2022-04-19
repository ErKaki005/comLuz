package comLuz.processor.readings.infraestructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import comLuz.processor.readings.domain.Reading;
import comLuz.processor.readings.domain.ReadingClientId;
import comLuz.processor.readings.domain.ReadingRepository;
import shared.comLuz.domain.Service;
import shared.comLuz.domain.criteria.Criteria;
import shared.comLuz.infraestructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("processor-transaction_manager")
public class MySqlReadingRepository extends HibernateRepository<Reading> implements ReadingRepository {
    public MySqlReadingRepository(@Qualifier("processor-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Reading.class);
    }

    @Override
    public void save(Reading reading) {
        persist(reading);
    }

    @Override
    public Optional<Reading> search(ReadingClientId clientId) {
        return byId(clientId);
    }

    @Override
    public List<Reading> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
