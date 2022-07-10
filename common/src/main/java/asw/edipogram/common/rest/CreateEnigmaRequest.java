package asw.edipogram.common.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEnigmaRequest implements Serializable {

    private String autore;
    private String tipo;
    private String tipoSpecifico;
    private String titolo;
    private String[] testo;

}