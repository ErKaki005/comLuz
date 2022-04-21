package shared.comLuz.infrastructure.bus.query;

import org.springframework.context.ApplicationContext;

import shared.comLuz.domain.Service;
import shared.comLuz.domain.bus.query.Query;
import shared.comLuz.domain.bus.query.QueryBus;
import shared.comLuz.domain.bus.query.QueryHandler;
import shared.comLuz.domain.bus.query.QueryHandlerExecutionError;
import shared.comLuz.domain.bus.query.Response;


@Service
public final class InMemoryQueryBus implements QueryBus {
    private final QueryHandlersInformation information;
    private final ApplicationContext       context;

    public InMemoryQueryBus(QueryHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

            QueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}
