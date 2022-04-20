package shared.comLuz.infrastructure.bus.event.file;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import shared.comLuz.domain.Utils;
import shared.comLuz.domain.bus.event.DomainEvent;
import shared.comLuz.domain.bus.event.EventBus;

public final class FileRecordEventBus implements EventBus{

	
    private final SessionFactory sessionFactory;

    public FileRecordEventBus(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }
	
	
    private void publish(DomainEvent domainEvent) {
        String                        id          = domainEvent.eventId();
        String                        aggregateId = domainEvent.aggregateId();
        String                        name        = domainEvent.eventName();
        HashMap<String, Serializable> body        = domainEvent.toPrimitives();
        String                        occurredOn  = domainEvent.occurredOn();

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
            "INSERT INTO domain_events (id,  aggregate_id, name,  body,  occurred_on) " +
            "VALUES (:id, :aggregateId, :name, :body, :occurredOn);"
        );

        query.setParameter("id", id)
             .setParameter("aggregateId", aggregateId)
             .setParameter("name", name)
             .setParameter("body", Utils.jsonEncode(body))
             .setParameter("occurredOn", occurredOn);

        query.executeUpdate();
    }
	
}
