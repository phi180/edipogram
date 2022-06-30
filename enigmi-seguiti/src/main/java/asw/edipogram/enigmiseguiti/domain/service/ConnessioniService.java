package asw.edipogram.enigmiseguiti.domain.service;

import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneVO;

import java.util.*;

public interface ConnessioniService {

	Collection<Connessione> getConnessioniByUtente(String utente);

	ConnessioneOutVO saveConnessione(ConnessioneVO connessioneVO);

	Collection<String> getUtentiByTipoEnigma(String tipoEnigma);
	
}
