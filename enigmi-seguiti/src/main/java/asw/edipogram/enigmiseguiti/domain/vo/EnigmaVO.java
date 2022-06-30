package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnigmaVO {
    private String autore;
    private String tipo;
    private String tipoSpecifico;
    private String titolo;
    private String[] testo;
}
