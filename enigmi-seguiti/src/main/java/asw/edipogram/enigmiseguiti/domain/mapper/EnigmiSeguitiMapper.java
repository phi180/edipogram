package asw.edipogram.enigmiseguiti.domain.mapper;

import asw.edipogram.common.dto.EnigmaSeguitoDTO;
import asw.edipogram.common.dto.EnigmiSeguitiDTO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoVO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;

import java.util.ArrayList;
import java.util.Collection;

public class EnigmiSeguitiMapper {

    public static EnigmaSeguitoVO buildFromEnigmaVOAndUtente(EnigmaVO enigmaVO, String utente) {
        EnigmaSeguitoVO enigmaSeguitoVO = new EnigmaSeguitoVO();
        enigmaSeguitoVO.setTipoEnigma(enigmaVO.getTipo());
        enigmaSeguitoVO.setTestoEnigma(enigmaVO.getTesto());
        enigmaSeguitoVO.setAutoreEnigma(enigmaVO.getAutore());
        enigmaSeguitoVO.setTipoSpecificoEnigma(enigmaVO.getTipoSpecifico());
        enigmaSeguitoVO.setTitoloEnigma(enigmaVO.getTitolo());
        enigmaSeguitoVO.setUtente(utente);

        return enigmaSeguitoVO;
    }

    public static EnigmaSeguitoDTO buildEnigmaSeguitoDTOFromVO(EnigmaSeguitoVO enigmaSeguitoVO) {
        EnigmaSeguitoDTO enigmaSeguitoDTO = new EnigmaSeguitoDTO();
        enigmaSeguitoDTO.setTestoEnigma(enigmaSeguitoVO.getTestoEnigma());
        enigmaSeguitoDTO.setTipoEnigma(enigmaSeguitoVO.getTipoEnigma());
        enigmaSeguitoDTO.setTitoloEnigma(enigmaSeguitoVO.getTitoloEnigma());
        enigmaSeguitoDTO.setTipoSpecificoEnigma(enigmaSeguitoVO.getTipoSpecificoEnigma());
        enigmaSeguitoDTO.setAutoreEnigma(enigmaSeguitoVO.getAutoreEnigma());
        enigmaSeguitoDTO.setUtente(enigmaSeguitoVO.getUtente());

        return enigmaSeguitoDTO;
    }

    public static EnigmiSeguitiDTO buildEnigmiSeguitiDTOFromVO(Collection<EnigmaSeguitoVO> enigmiSeguitiVOs) {
        EnigmiSeguitiDTO enigmiSeguitiDTO = new EnigmiSeguitiDTO();
        enigmiSeguitiDTO.setEnigmaSeguitoDTOCollection(new ArrayList<>());
        for(EnigmaSeguitoVO enigmaSeguitoVO: enigmiSeguitiVOs) {
            enigmiSeguitiDTO.getEnigmaSeguitoDTOCollection().add(buildEnigmaSeguitoDTOFromVO(enigmaSeguitoVO));
        }

        return enigmiSeguitiDTO;
    }


}
