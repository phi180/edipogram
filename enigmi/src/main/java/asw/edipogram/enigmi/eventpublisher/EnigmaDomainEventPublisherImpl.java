package asw.edipogram.enigmi.eventpublisher;

import asw.edipogram.common.channel.EnigmiServiceEventChannel;
import asw.edipogram.common.event.DomainEvent;
import asw.edipogram.enigmi.domain.EnigmaDomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class EnigmaDomainEventPublisherImpl implements EnigmaDomainEventPublisher {

    private final Logger logger = Logger.getLogger(EnigmaDomainEventPublisherImpl.class.toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = EnigmiServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("PUBLISHING EVENT: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}
