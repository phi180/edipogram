package asw.edipogram.enigmi.domain;

import asw.edipogram.common.event.DomainEvent;

public interface EnigmaDomainEventPublisher {

    void publish(DomainEvent event);
}
