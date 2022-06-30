package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
public class ConnessioniController {

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    @PostMapping("/connessioni")
    public void connessioneCreated(@RequestBody ConnessioneCreatedDTO connessioneCreatedDTO) {
        log.info("ConnessioniController - connessioneCreated(): connessioneCreatedDTO={}",connessioneCreatedDTO);

        Connessione connessione = new Connessione();
        connessione.setTipo(connessioneCreatedDTO.getTipo());
        connessione.setUtente(connessioneCreatedDTO.getUtente());

        connessione = connessioniService.saveConnessione(connessione);

        Collection<Enigma> enigmaCollection = enigmiService.getEnigmiByTipi(List.of(connessioneCreatedDTO.getTipo()));

        enigmiSeguitiService.saveEnigmiSeguitiByUtenteConnessione(connessioneCreatedDTO.getUtente(),enigmaCollection);
    }

}