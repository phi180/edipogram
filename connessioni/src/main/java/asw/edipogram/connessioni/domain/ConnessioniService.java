package asw.edipogram.connessioni.domain;

import asw.edipogram.connessioni.domain.entity.Connessione;
import asw.edipogram.connessioni.domain.proxy.ConnectorProxy;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class ConnessioniService {

	@Autowired
	private ConnessioniRepository connessioniRepository;

	@Autowired
	private ConnectorProxy connectorProxy;

 	public Connessione createConnessione(String utente, String tipo) {
		Connessione connessione = new Connessione(utente, tipo); 
		connessione = connessioniRepository.save(connessione);

		connectorProxy.forward(connessione);

		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findById(id).orElse(null);
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByUtente(String utente) {
		Collection<Connessione> connessioni = connessioniRepository.findByUtente(utente);
		return connessioni;
	}

}
