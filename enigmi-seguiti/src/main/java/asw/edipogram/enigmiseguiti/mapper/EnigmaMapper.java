package asw.edipogram.enigmiseguiti.mapper;

import asw.edipogram.common.dto.EnigmaCreatedDTO;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;

public class EnigmaMapper {

    public static EnigmaVO buildEnigmaVoFromDTO(EnigmaCreatedDTO enigmaCreatedDTO) {
        EnigmaVO enigmaVO = new EnigmaVO(enigmaCreatedDTO.getAutore(), enigmaCreatedDTO.getTipo(), enigmaCreatedDTO.getTipoSpecifico(),
                enigmaCreatedDTO.getTitolo(), enigmaCreatedDTO.getTesto());

        return enigmaVO;
    }

}