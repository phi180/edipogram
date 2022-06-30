package asw.edipogram.enigmiseguiti.webclient;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;

import java.util.*; 
import java.util.stream.*; 

@Service
public class EnigmiServiceWebClient {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<EnigmaOutVO> getEnigmiByTipi(Collection<String> tipi) {
		/*Collection<Enigma> enigmi = null;
        Flux<Enigma> response = loadBalancedWebClient
                .get()
				.uri("http://enigmi/cercaenigmi/tipi/{tipi}", toString(tipi))
                .retrieve()
                .bodyToFlux(Enigma.class);
        try {
            enigmi = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return enigmi; */
		return null;
	}

	public EnigmaOutVO saveEnigma(EnigmaVO enigmaVO) {
		return null;
	}

	private static String toString(Collection<String> c) {
		String result = 
			c.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining(",", "", ""));
		return result; 
	}

}
