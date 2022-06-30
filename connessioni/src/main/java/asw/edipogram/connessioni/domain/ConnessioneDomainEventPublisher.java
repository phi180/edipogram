package asw.edipogram.connessioni.domain;

import asw.edipogram.common.event.DomainEvent;

public interface ConnessioneDomainEventPublisher {
    void publish(DomainEvent event);
}
