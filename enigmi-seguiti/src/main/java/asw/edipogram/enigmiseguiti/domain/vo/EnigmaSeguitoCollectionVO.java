package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.Data;

import java.util.Collection;

@Data
public class EnigmaSeguitoCollectionVO {

    private Long enigmaId;

    private Collection<EnigmaSeguitoVO> enigmaSeguitoVOCollection;

}
