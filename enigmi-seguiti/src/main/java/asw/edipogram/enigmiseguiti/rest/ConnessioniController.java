package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.rest.CreateConnessioneRequest;
import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/connessioni")
@Slf4j
public class ConnessioniController {

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    @PostMapping
    public void connessioneCreated(@RequestBody CreateConnessioneRequest createConnessioneRequest) {
        log.info("ConnessioniController - connessioneCreated(): createConnessioneRequest={}", createConnessioneRequest);

        Connessione connessione = new Connessione();
        connessione.setTipo(createConnessioneRequest.getTipo());
        connessione.setUtente(createConnessioneRequest.getUtente());

        connessione = connessioniService.saveConnessione(connessione);

        Collection<Enigma> enigmaCollection = enigmiService.getEnigmiByTipi(List.of(createConnessioneRequest.getTipo()));

        enigmiSeguitiService.saveEnigmiSeguitiByUtenteConnessione(createConnessioneRequest.getUtente(),enigmaCollection);
    }

}