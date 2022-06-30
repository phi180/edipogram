package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;

import java.util.Collection;
import java.util.Map;

public interface EnigmiSeguitiService {

    /**
     *  @param enigma @return EnigmaSeguitoOutVO
     * @param utenti*/
    EnigmaSeguitoOutVO saveEnigmiSeguitiByEnigma(EnigmaVO enigma, Long idEnigma, Collection<String> utenti);

    EnigmaSeguitoOutVO saveEnigmiSeguitiByUtenteConnessione(String utente, Map<Long,EnigmaVO> enigmaVOMap);

    EnigmaSeguitoOutVO getEnigmiSeguiti(String utente);

}
