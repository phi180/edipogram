package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.service.ConnessioniService;
import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.repository.ConnessioniRepository;
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

    @Override
    public Collection<Connessione> getConnessioniByUtente(String utente) {
        return connessioniRepository.findConnessioneByUtente(utente);
    }

    public Connessione saveConnessione(Connessione connessione) {
        connessione = connessioniRepository.save(connessione);

        return connessione;
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
