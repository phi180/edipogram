package asw.edipogram.enigmiseguiti.domain;

import asw.edipogram.common.event.ConnessioneCreatedEvent;
import asw.edipogram.common.event.DomainEvent;
import asw.edipogram.common.event.EnigmaCreatedEvent;
import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@Slf4j
public class DomainEventConsumer {

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    public void onEvent(DomainEvent event) {
        log.info("DomainEventConsumer - onEvent(): event={}",event.getClass());

        if (event.getClass().equals(EnigmaCreatedEvent.class)) {
            EnigmaCreatedEvent ece = (EnigmaCreatedEvent) event;
            onEnigmaCreated(ece);
        } else if(event.getClass().equals(ConnessioneCreatedEvent.class)) {
            ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event;
            onConnessioneCreated(cce);
        } else {
            log.info("UNKNOWN EVENT: " + event);
        }

    }

    private void onEnigmaCreated(EnigmaCreatedEvent event) {
        log.info("DomainEventConsumer - onEnigmaCreated(): event={}",event);

        Enigma enigma = new Enigma(event.getAutore(),event.getTipo(), event.getTipoSpecifico(), event.getTitolo(), event.getTesto());
        enigma = enigmiService.saveEnigma(enigma);

        Collection<String> utentiCollection = connessioniService.getUtentiByTipoEnigma(enigma.getTipo());

        enigmiSeguitiService.saveEnigmiSeguitiByEnigma(enigma, utentiCollection);
    }

    private void onConnessioneCreated(ConnessioneCreatedEvent event) {
        log.info("DomainEventConsumer - onConnessioneCreated(): event={}",event);

        Connessione connessione = new Connessione(event.getUtente(),event.getTipo());
        connessione = connessioniService.saveConnessione(connessione);

        Collection<Enigma> enigmaCollection = enigmiService.getEnigmiByTipi(List.of(event.getTipo()));

        enigmiSeguitiService.saveEnigmiSeguitiByUtenteConnessione(event.getUtente(),enigmaCollection);
    }

}
