package asw.edipogram.enigmiseguiti.listener;

import asw.edipogram.common.channel.ConnessioniServiceEventChannel;
import asw.edipogram.common.channel.EnigmiServiceEventChannel;
import asw.edipogram.common.event.DomainEvent;
import asw.edipogram.enigmiseguiti.domain.DomainEventConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DomainEventListener {

    private final Logger logger = Logger.getLogger(DomainEventListener.class.toString());

    @Autowired
    private DomainEventConsumer domainEventConsumer;

    @KafkaListener(topics = {EnigmiServiceEventChannel.channel, ConnessioniServiceEventChannel.channel}, autoStartup = "${listen.auto.start:false}")
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("EVENT LISTENER: " + record.toString());
        DomainEvent event = record.value();
        domainEventConsumer.onEvent(event);
    }

}
