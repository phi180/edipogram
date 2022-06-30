package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguito;
import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguitoPK;
import asw.edipogram.enigmiseguiti.domain.enums.EnigmiSeguitiConstants;
import asw.edipogram.enigmiseguiti.domain.repository.EnigmiSeguitiRepository;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiSeguitiService;
import asw.edipogram.enigmiseguiti.domain.validator.Validator;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service 
public class EnigmiSeguitiServiceImpl implements EnigmiSeguitiService {

	@Autowired
	private EnigmiSeguitiRepository enigmiSeguitiRepository;

	@Autowired
	@Qualifier("enigmiSeguitiValidator")
	private Validator enigmiSeguitiValidator;

	@Override
	public EnigmaSeguitoOutVO getEnigmiSeguiti(String utente) {
		EnigmaSeguitoOutVO enigmaSeguitoOutVO = new EnigmaSeguitoOutVO();

		if(utente==null || utente.isEmpty()) {
			enigmaSeguitoOutVO.setCode(EnigmiSeguitiConstants.UTENTE_IS_NULL_OR_EMPTY.getCodice());
			enigmaSeguitoOutVO.setDescription(EnigmiSeguitiConstants.UTENTE_IS_NULL_OR_EMPTY.getDescrizione());
			return enigmaSeguitoOutVO;
		}

		enigmaSeguitoOutVO.setEnigmaSeguitoVOs(new ArrayList<>());

		Collection<EnigmaSeguito> enigmaSeguitoCollection = enigmiSeguitiRepository.findAllByEnigmaSeguitoPKUtente(utente);
		for(EnigmaSeguito enigmaSeguito: enigmaSeguitoCollection) {
			EnigmaSeguitoVO enigmaSeguitoVO = this.buildEnigmaSeguitoFromEntity(enigmaSeguito);
			enigmaSeguitoOutVO.getEnigmaSeguitoVOs().add(enigmaSeguitoVO);
		}

		enigmaSeguitoOutVO.setCode(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getCodice());
		enigmaSeguitoOutVO.setDescription(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getDescrizione());

		return enigmaSeguitoOutVO;
	}

	@Override
	public EnigmaSeguitoOutVO saveEnigmiSeguitiByEnigma(EnigmaVO enigma, Long idEnigma, Collection<String> utentiCollection) {
		EnigmaSeguitoOutVO enigmaSeguitoOutVO = new EnigmaSeguitoOutVO();

		for(String utente : utentiCollection) {
			EnigmaSeguito enigmaSeguito =
					this.buildEnigmaSeguitoFromEnigmaVOAndUtente(utente, enigma, idEnigma);
			enigmiSeguitiRepository.save(enigmaSeguito);
		}
		enigmaSeguitoOutVO.setCode(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getCodice());
		enigmaSeguitoOutVO.setDescription(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getDescrizione());

		return enigmaSeguitoOutVO;
	}

	@Override
	public EnigmaSeguitoOutVO saveEnigmiSeguitiByUtenteConnessione(String utente, Map<Long, EnigmaVO> enigmaVOMap) {
		EnigmaSeguitoOutVO enigmaSeguitoOutVO = new EnigmaSeguitoOutVO();

		for(Map.Entry<Long,EnigmaVO> enigma : enigmaVOMap.entrySet()) {
			EnigmaSeguito enigmaSeguito =
					this.buildEnigmaSeguitoFromEnigmaVOAndUtente(utente, enigma.getValue(), enigma.getKey());
			enigmiSeguitiRepository.save(enigmaSeguito);
		}
		enigmaSeguitoOutVO.setCode(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getCodice());
		enigmaSeguitoOutVO.setDescription(EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getDescrizione());

		return enigmaSeguitoOutVO;
	}

	private EnigmaSeguito buildEnigmaSeguitoFromEnigmaVOAndUtente(String utente, EnigmaVO enigmaVO, Long enigmaId) {
		EnigmaSeguitoPK enigmaSeguitoPK = new EnigmaSeguitoPK();
		enigmaSeguitoPK.setUtente(utente);
		enigmaSeguitoPK.setIdEnigma(enigmaId);

		EnigmaSeguito enigmaSeguito = new EnigmaSeguito();
		enigmaSeguito.setEnigmaSeguitoPK(enigmaSeguitoPK);

		enigmaSeguito.setAutoreEnigma(enigmaVO.getAutore());
		enigmaSeguito.setTestoEnigma(enigmaVO.getTesto());
		enigmaSeguito.setTipoEnigma(enigmaVO.getTipo());
		enigmaSeguito.setTipoSpecificoEnigma(enigmaVO.getTipoSpecifico());
		enigmaSeguito.setTitoloEnigma(enigmaVO.getTitolo());

		return enigmaSeguito;
	}

	private EnigmaSeguitoVO buildEnigmaSeguitoFromEntity(EnigmaSeguito enigmaSeguito) {
		EnigmaSeguitoVO enigmaSeguitoVO = new EnigmaSeguitoVO();
		enigmaSeguitoVO.setTitoloEnigma(enigmaSeguito.getTitoloEnigma());
		enigmaSeguitoVO.setTipoEnigma(enigmaSeguito.getTipoEnigma());
		enigmaSeguitoVO.setTestoEnigma(enigmaSeguito.getTestoEnigma());
		enigmaSeguitoVO.setAutoreEnigma(enigmaSeguito.getAutoreEnigma());
		enigmaSeguitoVO.setUtente(enigmaSeguito.getEnigmaSeguitoPK().getUtente());
		enigmaSeguitoVO.setTipoSpecificoEnigma(enigmaSeguito.getTipoSpecificoEnigma());

		return enigmaSeguitoVO;
	}


}
