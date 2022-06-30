package asw.edipogram.enigmiseguiti.domain.vo;

import lombok.Data;

@Data
public class EnigmaSeguitoVO {

    private String utente;

    private String autoreEnigma;
    private String tipoEnigma;
    private String tipoSpecificoEnigma;
    private String titoloEnigma;
    private String[] testoEnigma;

}
