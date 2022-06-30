package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
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

@RestController
@Slf4j
public class EnigmiController {

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    @PostMapping("/enigmi")
    public void enigmaCreated(@RequestBody EnigmaCreatedDTO enigmaCreatedDTO) {
        log.info("EnigmiController - enigmaCreated(): enigmaCreatedDTO={}",enigmaCreatedDTO);

        Enigma enigma = new Enigma();
        enigma.setAutore(enigmaCreatedDTO.getAutore());
        enigma.setTesto(enigmaCreatedDTO.getTesto());
        enigma.setTipo(enigmaCreatedDTO.getTipo());
        enigma.setTitolo(enigmaCreatedDTO.getTitolo());
        enigma.setTipoSpecifico(enigmaCreatedDTO.getTipoSpecifico());

        enigma = enigmiService.saveEnigma(enigma);

        Collection<String> utentiCollection = connessioniService.getUtentiByTipoEnigma(enigma.getTipo());
        enigmiSeguitiService.saveEnigmiSeguitiByEnigma(enigma, utentiCollection);
    }

}