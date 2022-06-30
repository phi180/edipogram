package asw.edipogram.connessioni.eventpublisher;

import asw.edipogram.common.channel.ConnessioniServiceEventChannel;
import asw.edipogram.common.event.DomainEvent;
import asw.edipogram.connessioni.domain.ConnessioneDomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioneDomainEventPublisherImpl implements ConnessioneDomainEventPublisher {

    private final Logger logger = Logger.getLogger(ConnessioneDomainEventPublisherImpl.class.toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioniServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}
