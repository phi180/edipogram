package asw.edipogram.enigmiseguiti.webclient;

import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;

import java.util.*; 

public class ConnessioniServiceWebClient {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<Connessione> getConnessioniByUtente(String utente) {
		Collection<Connessione> connessioni = null; 
        Flux<Connessione> response = loadBalancedWebClient
                .get()
				.uri("http://connessioni/connessioni/{utente}", utente)
                .retrieve()
                .bodyToFlux(Connessione.class);
        try {
            connessioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return connessioni; 
	}	

}
