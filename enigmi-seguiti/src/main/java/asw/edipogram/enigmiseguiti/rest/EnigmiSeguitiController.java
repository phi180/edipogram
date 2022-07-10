package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguito;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant; 
import java.time.Duration;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
@RequestMapping("/enigmiseguiti")
public class EnigmiSeguitiController {

	private final Logger logger = Logger.getLogger(EnigmiSeguitiController.class.toString()); 

	@Autowired 
	private EnigmiSeguitiService enigmiSeguitiServiceImpl;

	/* Trova gli enigmi (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/{utente}")
	public Collection<EnigmaSeguito> getEnigmiSeguiti(@PathVariable String utente) {
		Instant start = Instant.now();

		logger.info("REST CALL: getEnigmiSeguiti " + utente);
		Collection<EnigmaSeguito> enigmiSeguiti = enigmiSeguitiServiceImpl.getEnigmiSeguiti(utente);

		Duration duration = Duration.between(start, Instant.now());
		logger.info("getEnigmiSeguiti " + utente + " (trovati " + enigmiSeguiti.size() + " enigmi in " + duration.toMillis() + " ms): " + enigmiSeguiti);

		return enigmiSeguiti;
	}
	
}
