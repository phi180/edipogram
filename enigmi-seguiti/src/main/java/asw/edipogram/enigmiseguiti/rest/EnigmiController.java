package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.rest.CreateEnigmaRequest;
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

@RestController
@RequestMapping("/enigmi")
@Slf4j
public class EnigmiController {

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    @PostMapping
    public void enigmaCreated(@RequestBody CreateEnigmaRequest createEnigmaRequest) {
        log.info("EnigmiController - enigmaCreated(): createEnigmaRequest={}", createEnigmaRequest);

        Enigma enigma = new Enigma();
        enigma.setAutore(createEnigmaRequest.getAutore());
        enigma.setTesto(createEnigmaRequest.getTesto());
        enigma.setTipo(createEnigmaRequest.getTipo());
        enigma.setTitolo(createEnigmaRequest.getTitolo());
        enigma.setTipoSpecifico(createEnigmaRequest.getTipoSpecifico());

        enigma = enigmiService.saveEnigma(enigma);

        Collection<String> utentiCollection = connessioniService.getUtentiByTipoEnigma(enigma.getTipo());
        enigmiSeguitiService.saveEnigmiSeguitiByEnigma(enigma, utentiCollection);
    }

}