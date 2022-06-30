package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.enums.ConnessioniConstants;
import asw.edipogram.enigmiseguiti.domain.repository.ConnessioniRepository;
import asw.edipogram.enigmiseguiti.domain.validator.ConnessioneValidator;
import asw.edipogram.enigmiseguiti.domain.validator.ValidatorResponse;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Primary
public class ConnessioniServiceImpl implements ConnessioniService {

    @Autowired
    private ConnessioniRepository connessioniRepository;

    @Autowired
    private ConnessioneValidator connessioneValidator;

    @Override
    public Collection<Connessione> getConnessioniByUtente(String utente) {
        return connessioniRepository.findConnessioneByUtente(utente);
    }

    public ConnessioneOutVO saveConnessione(ConnessioneVO connessioneVO) {
        ConnessioneOutVO connessioneOutVO = new ConnessioneOutVO();
        ValidatorResponse validatorResponse = connessioneValidator.isValid(connessioneVO);

        if(!validatorResponse.getIsValid()) {
            connessioneOutVO.setCode(validatorResponse.getCode());
            connessioneOutVO.setDescription(validatorResponse.getDescription());
            return connessioneOutVO;
        }

        Connessione connessione = new Connessione(connessioneVO.getUtente(),connessioneVO.getTipo());
        connessione = connessioniRepository.save(connessione);

        connessioneOutVO.setCode(ConnessioniConstants.CONNESSIONE_OK.getCodice());
        connessioneOutVO.setDescription(ConnessioniConstants.CONNESSIONE_OK.getDescrizione());
        connessioneOutVO.setConnessioneVO(connessioneVO);

        return connessioneOutVO;
    }

    @Override
    public Collection<String> getUtentiByTipoEnigma(String tipoEnigma) {
        Collection<String> utenti = connessioniRepository.findUtentiByTipo(tipoEnigma);
        if(utenti == null) {
            utenti = new ArrayList<>();
        }

        return utenti;
    }

}
