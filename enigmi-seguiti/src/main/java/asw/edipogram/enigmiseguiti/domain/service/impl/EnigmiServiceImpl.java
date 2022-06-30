package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.repository.EnigmiRepository;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Primary
public class EnigmiServiceImpl implements EnigmiService {

    @Autowired
    private EnigmiRepository enigmiRepository;

    @Override
    public Collection<Enigma> getEnigmiByTipi(Collection<String> tipi) {
        Collection<Enigma> enigmaCollection = enigmiRepository.findEnigmasByTipo(tipi);

        return enigmaCollection;
    }

    @Override
    public Enigma saveEnigma(Enigma enigma) {
        enigma = enigmiRepository.save(enigma);

        return enigma;
    }

}
