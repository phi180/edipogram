package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ConnessioneOutVO extends BaseOutVO {

    private ConnessioneVO connessioneVO;

}
