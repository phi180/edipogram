package asw.edipogram.enigmiseguiti.domain.service.impl;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import asw.edipogram.enigmiseguiti.domain.enums.EnigmiConstants;
import asw.edipogram.enigmiseguiti.domain.repository.EnigmiRepository;
import asw.edipogram.enigmiseguiti.domain.service.EnigmiService;
import asw.edipogram.enigmiseguiti.domain.validator.EnigmaValidator;
import asw.edipogram.enigmiseguiti.domain.validator.ValidatorResponse;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaCollectionOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaOutVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Primary
public class EnigmiServiceImpl implements EnigmiService {

    @Autowired
    private EnigmiRepository enigmiRepository;

    @Autowired
    private EnigmaValidator enigmaValidator;

    @Override
    public EnigmaCollectionOutVO getEnigmiByTipi(Collection<String> tipi) {
        EnigmaCollectionOutVO enigmaCollectionOutVO = null;

        if(tipi == null || tipi.isEmpty() || tipi.stream().anyMatch(tipo -> tipo==null || tipo.isEmpty())) {
            enigmaCollectionOutVO = new EnigmaCollectionOutVO();
            enigmaCollectionOutVO.setCode(EnigmiConstants.TIPO_IS_NULL_OR_EMPTY.getCodice());
            enigmaCollectionOutVO.setDescription(EnigmiConstants.TIPO_IS_NULL_OR_EMPTY.getDescrizione());
            return enigmaCollectionOutVO;
        }

        Collection<Enigma> enigmaCollection = enigmiRepository.findEnigmasByTipo(tipi);

        enigmaCollectionOutVO = this.enigmaCollectionOutVOMapper(enigmaCollection);

        enigmaCollectionOutVO.setCode(EnigmiConstants.ENIGMA_OK.getCodice());
        enigmaCollectionOutVO.setDescription(EnigmiConstants.ENIGMA_OK.getDescrizione());

        return enigmaCollectionOutVO;
    }

    @Override
    public EnigmaOutVO saveEnigma(EnigmaVO enigmaVO) {
        EnigmaOutVO enigmaOutVO = new EnigmaOutVO();
        ValidatorResponse validatorResponse = enigmaValidator.isValid(enigmaVO);

        if(!validatorResponse.getIsValid()) {
            enigmaOutVO.setCode(validatorResponse.getCode());
            enigmaOutVO.setDescription(validatorResponse.getDescription());
            return enigmaOutVO;
        }

        Enigma enigma = new Enigma(enigmaVO.getAutore(), enigmaVO.getTipo(), enigmaVO.getTipoSpecifico(),
                enigmaVO.getTitolo(),enigmaVO.getTesto());
        enigma = enigmiRepository.save(enigma);

        enigmaOutVO.setCode(EnigmiConstants.ENIGMA_OK.getCodice());
        enigmaOutVO.setDescription(EnigmiConstants.ENIGMA_OK.getDescrizione());
        enigmaOutVO.setIdEnigma(enigma.getId());
        enigmaOutVO.setEnigmaVO(enigmaVO);
        return enigmaOutVO;
    }

    private EnigmaCollectionOutVO enigmaCollectionOutVOMapper(Collection<Enigma> enigmaCollection) {
        EnigmaCollectionOutVO enigmaCollectionOutVO = new EnigmaCollectionOutVO();

        for(Enigma enigma : enigmaCollection) {
            EnigmaVO enigmaVO = new EnigmaVO(enigma.getAutore(),enigma.getTipo(),enigma.getTipoSpecifico(),
                    enigma.getTitolo(),enigma.getTesto());
            enigmaCollectionOutVO.getEnigmaVOMap().put(enigma.getId(),enigmaVO);
        }

        return enigmaCollectionOutVO;
    }

}
