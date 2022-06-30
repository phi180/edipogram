package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguito;
import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguitoPK;
import asw.edipogram.enigmiseguiti.domain.repository.EnigmiSeguitiRepository;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service 
public class EnigmiSeguitiServiceImpl implements EnigmiSeguitiService {

	@Autowired
	private EnigmiSeguitiRepository enigmiSeguitiRepository;

	@Override
	public Collection<EnigmaSeguito> getEnigmiSeguiti(String utente) {
		Collection<EnigmaSeguito> enigmaSeguitoCollection = enigmiSeguitiRepository.findAllByEnigmaSeguitoPKUtente(utente);

		return enigmaSeguitoCollection;
	}

	@Override
	public Collection<EnigmaSeguito> saveEnigmiSeguitiByEnigma(Enigma enigma, Collection<String> utentiCollection) {
		Collection<EnigmaSeguito> enigmaSeguitoCollection = new ArrayList<>();

		for(String utente : utentiCollection) {
			EnigmaSeguito enigmaSeguito = this.buildEnigmaSeguitoFromEnigmaAndUtente(enigma, utente);
			enigmaSeguito = enigmiSeguitiRepository.save(enigmaSeguito);

			enigmaSeguitoCollection.add(enigmaSeguito);
		}

		return enigmaSeguitoCollection;
	}

	@Override
	public Collection<EnigmaSeguito> saveEnigmiSeguitiByUtenteConnessione(String utente, Collection<Enigma> enigmi) {
		Collection<EnigmaSeguito> enigmaSeguitoCollection = new ArrayList<>();

		for(Enigma enigma : enigmi) {
			EnigmaSeguito enigmaSeguito = this.buildEnigmaSeguitoFromEnigmaAndUtente(enigma, utente);
			enigmaSeguito = enigmiSeguitiRepository.save(enigmaSeguito);

			enigmaSeguitoCollection.add(enigmaSeguito);
		}

		return enigmaSeguitoCollection;
	}

	private EnigmaSeguito buildEnigmaSeguitoFromEnigmaAndUtente(Enigma enigma, String utente) {
		EnigmaSeguito enigmaSeguito = new EnigmaSeguito();

		EnigmaSeguitoPK enigmaSeguitoPK = new EnigmaSeguitoPK();
		enigmaSeguitoPK.setIdEnigma(enigma.getId());
		enigmaSeguitoPK.setUtente(utente);

		enigmaSeguito.setEnigmaSeguitoPK(enigmaSeguitoPK);
		enigmaSeguito.setTitoloEnigma(enigma.getTitolo());
		enigmaSeguito.setTipoEnigma(enigma.getTipo());
		enigmaSeguito.setTestoEnigma(enigma.getTesto());
		enigmaSeguito.setAutoreEnigma(enigma.getAutore());
		enigmaSeguito.setTipoSpecificoEnigma(enigma.getTipoSpecifico());

		return enigmaSeguito;
	}


}
