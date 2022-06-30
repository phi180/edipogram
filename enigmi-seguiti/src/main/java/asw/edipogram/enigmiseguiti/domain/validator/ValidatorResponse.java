package asw.edipogram.enigmiseguiti.domain.validator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidatorResponse {

    private Boolean isValid;

    private Long code;
    private String description;

}
