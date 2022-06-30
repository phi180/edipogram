package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=false)
public class EnigmaCollectionOutVO extends BaseOutVO {

    private Map<Long,EnigmaVO> enigmaVOMap;

    public EnigmaCollectionOutVO() {
        enigmaVOMap = new HashMap<>();
    }
}
