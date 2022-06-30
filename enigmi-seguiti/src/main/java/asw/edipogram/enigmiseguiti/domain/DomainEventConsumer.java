package asw.edipogram.enigmiseguiti.domain;

import asw.edipogram.common.event.ConnessioneCreatedEvent;
import asw.edipogram.common.event.DomainEvent;
import asw.edipogram.common.event.EnigmaCreatedEvent;
import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.enums.ConnessioniConstants;
import asw.edipogram.enigmiseguiti.domain.enums.EnigmiConstants;
import asw.edipogram.enigmiseguiti.domain.exceptions.EdipogramException;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import asw.edipogram.enigmiseguiti.domain.vo.*;
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

        EnigmaVO enigmaInVO = new EnigmaVO(event.getAutore(),event.getTipo(), event.getTipoSpecifico(), event.getTitolo(), event.getTesto());
        EnigmaOutVO enigmaOutVO = enigmiService.saveEnigma(enigmaInVO);

        if(!EnigmiConstants.ENIGMA_OK.getCodice().equals(enigmaOutVO.getCode())) {
            throw new EdipogramException(enigmaOutVO.getCode(),enigmaOutVO.getDescription());
        }

        Collection<String> utentiCollection = connessioniService.getUtentiByTipoEnigma(enigmaOutVO.getEnigmaVO().getTipo());
        EnigmaSeguitoOutVO enigmaSeguitoOutVO = enigmiSeguitiService.saveEnigmiSeguitiByEnigma(enigmaOutVO.getEnigmaVO(), enigmaOutVO.getIdEnigma(), utentiCollection);
    }

    private void onConnessioneCreated(ConnessioneCreatedEvent event) {
        log.info("DomainEventConsumer - onConnessioneCreated(): event={}",event);

        ConnessioneVO connessioneInVO = new ConnessioneVO(event.getUtente(),event.getTipo());
        ConnessioneOutVO connessioneOutVO = connessioniService.saveConnessione(connessioneInVO);

        if(!ConnessioniConstants.CONNESSIONE_OK.getCodice().equals(connessioneOutVO.getCode())) {
            throw new EdipogramException(connessioneOutVO.getCode(),connessioneOutVO.getDescription());
        }

        EnigmaCollectionOutVO enigmaCollectionOutVO = enigmiService.getEnigmiByTipi(List.of(event.getTipo()));
        EnigmaSeguitoOutVO enigmaSeguitoOutVO = enigmiSeguitiService.saveEnigmiSeguitiByUtenteConnessione(event.getUtente(),enigmaCollectionOutVO.getEnigmaVOMap());

    }

}
