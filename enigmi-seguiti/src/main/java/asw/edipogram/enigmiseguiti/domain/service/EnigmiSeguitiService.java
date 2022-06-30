package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguito;

import java.util.Collection;
import java.util.Map;

public interface EnigmiSeguitiService {

    /**
     *  @param enigma @return EnigmaSeguitoOutVO
     * @param utenti*/
    Collection<EnigmaSeguito> saveEnigmiSeguitiByEnigma(Enigma enigma, Collection<String> utenti);

    Collection<EnigmaSeguito> saveEnigmiSeguitiByUtenteConnessione(String utente, Collection<Enigma> enigmi);

    Collection<EnigmaSeguito> getEnigmiSeguiti(String utente);

}
