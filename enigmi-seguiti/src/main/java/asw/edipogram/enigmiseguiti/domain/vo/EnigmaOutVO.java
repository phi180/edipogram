package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EnigmaOutVO extends BaseOutVO {

    private Long idEnigma;
    private EnigmaVO enigmaVO;

}
