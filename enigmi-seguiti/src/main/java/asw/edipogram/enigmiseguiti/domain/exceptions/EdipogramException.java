package asw.edipogram.enigmiseguiti.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EdipogramException extends RuntimeException {

    private Long code;
    private String description;

}
