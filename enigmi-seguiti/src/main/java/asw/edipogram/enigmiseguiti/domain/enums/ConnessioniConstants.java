package asw.edipogram.enigmiseguiti.domain.enums;

import lombok.Getter;

@Getter
public enum ConnessioniConstants {

    CONNESSIONE_OK(0L, "OK"),
    CONNESSIONE_IS_NULL(1L, "Connessione è null"),
    UTENTE_IS_NULL_OR_EMPTY(2L, "L'utente della connessione è null o vuoto"),
    TIPO_IS_NULL_OR_EMPTY(3L, "Il tipo della connessione è null o vuoto"),

    UNKNOWN(-1L, "Errore sconosciuto"),
    ;

    ConnessioniConstants(Long codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    private Long codice;
    private String descrizione;

}
