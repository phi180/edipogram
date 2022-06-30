package asw.edipogram.enigmiseguiti.rest;

import asw.edipogram.common.dto.EnigmaSeguitoDTO;
import asw.edipogram.common.dto.EnigmiSeguitiDTO;
import asw.edipogram.enigmiseguiti.domain.mapper.EnigmiSeguitiMapper;
import asw.edipogram.enigmiseguiti.domain.service.impl.EnigmiSeguitiServiceImpl;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoVO;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant; 
import java.time.Duration; 

import java.util.logging.Logger;

@RestController
public class EnigmiSeguitiController {

	private final Logger logger = Logger.getLogger(EnigmiSeguitiController.class.toString()); 

	@Autowired 
	private EnigmiSeguitiServiceImpl enigmiSeguitiServiceImpl;

	/* Trova gli enigmi (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/enigmiseguiti/{utente}")
	public EnigmiSeguitiDTO getEnigmiSeguiti(@PathVariable String utente) {
		Instant start = Instant.now();

		logger.info("REST CALL: getEnigmiSeguiti " + utente);
		EnigmaSeguitoOutVO enigmi = enigmiSeguitiServiceImpl.getEnigmiSeguiti(utente);

		Duration duration = Duration.between(start, Instant.now());
		logger.info("getEnigmiSeguiti " + utente + " (trovati " + enigmi.getEnigmaSeguitoVOs().size() + " enigmi in " + duration.toMillis() + " ms): " + enigmi);

		return EnigmiSeguitiMapper.buildEnigmiSeguitiDTOFromVO(enigmi.getEnigmaSeguitoVOs());
	}
	
}
