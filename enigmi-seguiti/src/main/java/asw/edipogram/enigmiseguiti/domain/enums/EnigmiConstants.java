package asw.edipogram.enigmiseguiti.domain.enums;

import lombok.Getter;

@Getter
public enum EnigmiConstants {

    ENIGMA_OK(0L,"OK"),
    ENIGMA_IS_NULL(1L,"L'enigma è null"),
    AUTORE_IS_NULL_OR_EMPTY(2L,"L'autore dell'enigma è null o vuoto"),
    TIPO_IS_NULL_OR_EMPTY(3L, "Il tipo dell'enigma è null o vuoto"),
    TIPOSPECIFICO_IS_NULL_OR_EMPTY(4L, "Il tipo specifico dell'enigma è null o vuoto"),
    TITOLO_IS_NULL_OR_EMPTY(5L, "Il titolo dell'enigma è null o vuoto"),
    TESTO_IS_NULL_OR_EMPTY(6L, "Il testo dell'enigma è null o vuoto"),

    UNKNOWN_ERROR(-1L,"Errore sconosciuto"),
    ;

    EnigmiConstants(Long codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    private Long codice;
    private String descrizione;

}
