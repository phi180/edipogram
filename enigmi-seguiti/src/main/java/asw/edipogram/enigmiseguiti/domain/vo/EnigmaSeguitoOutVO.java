package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EnigmaSeguitoOutVO extends BaseOutVO {

    private Collection<EnigmaSeguitoVO> enigmaSeguitoVOs;

}
