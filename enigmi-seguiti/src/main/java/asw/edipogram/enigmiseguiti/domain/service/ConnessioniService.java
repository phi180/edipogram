package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.entity.Connessione;

import java.util.*;

public interface ConnessioniService {

	Collection<Connessione> getConnessioniByUtente(String utente);

	Connessione saveConnessione(Connessione connessione);

	Collection<String> getUtentiByTipoEnigma(String tipoEnigma);
	
}
