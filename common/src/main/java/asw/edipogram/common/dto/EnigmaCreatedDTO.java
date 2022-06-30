package asw.edipogram.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnigmaCreatedDTO implements Serializable {

    private String autore;
    private String tipo;
    private String tipoSpecifico;
    private String titolo;
    private String[] testo;

}