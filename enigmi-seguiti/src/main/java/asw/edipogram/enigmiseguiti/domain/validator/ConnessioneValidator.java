package asw.edipogram.enigmiseguiti.domain.validator;

import asw.edipogram.enigmiseguiti.domain.enums.ConnessioniConstants;
import asw.edipogram.enigmiseguiti.domain.vo.ConnessioneVO;
import org.springframework.stereotype.Component;

@Component
public class ConnessioneValidator implements Validator<ConnessioneVO> {

    @Override
    public ValidatorResponse isValid(ConnessioneVO connessione) {
        if (connessione == null)
            return new ValidatorResponse(false, ConnessioniConstants.CONNESSIONE_IS_NULL.getCodice(), ConnessioniConstants.CONNESSIONE_IS_NULL.getDescrizione());
        if (connessione.getUtente() == null || connessione.getUtente().isEmpty())
            return new ValidatorResponse(false, ConnessioniConstants.UTENTE_IS_NULL_OR_EMPTY.getCodice(), ConnessioniConstants.UTENTE_IS_NULL_OR_EMPTY.getDescrizione());
        if (connessione.getTipo() == null || connessione.getTipo().isEmpty())
            return new ValidatorResponse(false, ConnessioniConstants.TIPO_IS_NULL_OR_EMPTY.getCodice(), ConnessioniConstants.TIPO_IS_NULL_OR_EMPTY.getDescrizione());

        return new ValidatorResponse(true, ConnessioniConstants.CONNESSIONE_OK.getCodice(), ConnessioniConstants.CONNESSIONE_OK.getDescrizione());
    }
}
