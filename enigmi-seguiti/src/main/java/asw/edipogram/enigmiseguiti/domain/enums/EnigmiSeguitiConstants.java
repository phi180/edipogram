package asw.edipogram.enigmiseguiti.domain.enums;

import lombok.Getter;

@Getter
public enum EnigmiSeguitiConstants {

    ENIGMASEGUITO_OK(0L,"OK"),
    ENIGMASEGUITO_IS_NULL(1L, "L'enigma seguito è null"),
    TIPO_IS_NULL_OR_EMPTY(2L,"Il tipo è null o vuoto"),
    UTENTE_IS_NULL_OR_EMPTY(3L, "L'utente della connessione è null o vuoto"),
    AUTORE_IS_NULL_OR_EMPTY(4L, "L'autore dell'enigma è null o vuoto"),
    TESTO_IS_NULL_OR_EMPTY(5L, "Il testo è null o vuoto"),
    TITOLO_IS_NULL_OR_EMPTY(6L, "Il titolo è null o vuoto"),
    TIPOSPECIFICO_IS_NULL_OR_EMPTY(7L, "Il tipo specifico è null o vuoto"),

    UNKNOWN_ERROR(-1L,"Errore sconosciuto"),
    ;

    EnigmiSeguitiConstants(Long codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    private Long codice;
    private String descrizione;

}
