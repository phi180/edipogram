package asw.edipogram.enigmiseguiti.mapper;

import asw.edipogram.common.dto.ConnessioneCreatedDTO;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneVO;

public class ConnessioneMapper {

    public static ConnessioneVO buildConnessioneVOfromDTO(ConnessioneCreatedDTO connessioneCreatedDTO) {
        return new ConnessioneVO(connessioneCreatedDTO.getUtente(), connessioneCreatedDTO.getTipo());
    }

}