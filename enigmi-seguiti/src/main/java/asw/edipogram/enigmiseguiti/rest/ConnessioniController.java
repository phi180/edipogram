package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.enigmiseguiti.domain.enums.ConnessioniConstants;
import asw.edipogram.enigmiseguiti.domain.exceptions.EdipogramException;
import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaCollectionOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoOutVO;
import asw.edipogram.enigmiseguiti.mapper.ConnessioneMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

        ConnessioneOutVO connessioneOutVO = connessioniService.saveConnessione(ConnessioneMapper.buildConnessioneVOfromDTO(connessioneCreatedDTO));

        if(!ConnessioniConstants.CONNESSIONE_OK.getCodice().equals(connessioneOutVO.getCode())) {
            throw new EdipogramException(connessioneOutVO.getCode(),connessioneOutVO.getDescription());
        }

        EnigmaCollectionOutVO enigmaCollectionOutVO = enigmiService.getEnigmiByTipi(List.of(connessioneCreatedDTO.getTipo()));
        EnigmaSeguitoOutVO enigmaSeguitoOutVO = enigmiSeguitiService.saveEnigmiSeguitiByUtenteConnessione(connessioneCreatedDTO.getUtente(),enigmaCollectionOutVO.getEnigmaVOMap());

    }

}