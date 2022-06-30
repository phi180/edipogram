package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.enigmiseguiti.domain.enums.EnigmiConstants;
import asw.edipogram.enigmiseguiti.domain.exceptions.EdipogramException;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;
import asw.edipogram.enigmiseguiti.mapper.EnigmaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
@Slf4j
public class EnigmiController {

    private final Logger logger = Logger.getLogger(EnigmiController.class.toString());

    @Autowired
    private EnigmiService enigmiService;

    @Autowired
    private ConnessioniService connessioniService;

    @Autowired
    private EnigmiSeguitiService enigmiSeguitiService;

    @PostMapping("/enigmi")
    public void enigmaCreated(@RequestBody EnigmaCreatedDTO enigmaCreatedDTO) {
        log.info("EnigmiController - enigmaCreated(): enigmaCreatedDTO={}",enigmaCreatedDTO);

        EnigmaVO enigmaVO = EnigmaMapper.buildEnigmaVoFromDTO(enigmaCreatedDTO);
        EnigmaOutVO enigmaOutVO = enigmiService.saveEnigma(enigmaVO);

        if(!EnigmiConstants.ENIGMA_OK.getCodice().equals(enigmaOutVO.getCode())) {
            throw new EdipogramException(enigmaOutVO.getCode(),enigmaOutVO.getDescription());
        }

        Collection<String> utentiCollection = connessioniService.getUtentiByTipoEnigma(enigmaOutVO.getEnigmaVO().getTipo());
        EnigmaSeguitoOutVO enigmaSeguitoOutVO = enigmiSeguitiService.saveEnigmiSeguitiByEnigma(enigmaOutVO.getEnigmaVO(), enigmaOutVO.getIdEnigma(), utentiCollection);
    }

}