package asw.edipogram.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnigmiSeguitiDTO {

    private Collection<EnigmaSeguitoDTO> enigmaSeguitoDTOCollection;

}
