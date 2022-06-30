package asw.edipogram.enigmiseguiti.domain.validator;

import asw.edipogram.enigmiseguiti.domain.enums.EnigmiSeguitiConstants;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaSeguitoVO;
import org.springframework.stereotype.Component;

@Component("enigmiSeguitiValidator")
public class EnigmiSeguitiValidator implements Validator<EnigmaSeguitoVO> {

    private static final Integer ZERO = 0;

    @Override
    public ValidatorResponse isValid(EnigmaSeguitoVO enigmaSeguitoVO) {
        if(enigmaSeguitoVO == null)
            return new ValidatorResponse(false, EnigmiSeguitiConstants.ENIGMASEGUITO_IS_NULL.getCodice(),EnigmiSeguitiConstants.ENIGMASEGUITO_IS_NULL.getDescrizione());
        if(enigmaSeguitoVO.getAutoreEnigma() == null || enigmaSeguitoVO.getAutoreEnigma().isEmpty())
            return new ValidatorResponse(false, EnigmiSeguitiConstants.AUTORE_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.AUTORE_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigmaSeguitoVO.getTestoEnigma() == null || enigmaSeguitoVO.getTestoEnigma().length == ZERO)
            return new ValidatorResponse(false, EnigmiSeguitiConstants.TESTO_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.TESTO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigmaSeguitoVO.getTipoEnigma() == null || enigmaSeguitoVO.getTipoEnigma().isEmpty())
            return new ValidatorResponse(false, EnigmiSeguitiConstants.TIPO_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.TIPO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigmaSeguitoVO.getTipoSpecificoEnigma() == null || enigmaSeguitoVO.getTipoSpecificoEnigma().isEmpty())
            return new ValidatorResponse(false, EnigmiSeguitiConstants.TIPOSPECIFICO_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.TIPOSPECIFICO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigmaSeguitoVO.getTitoloEnigma() == null || enigmaSeguitoVO.getTitoloEnigma().isEmpty())
            return new ValidatorResponse(false, EnigmiSeguitiConstants.TITOLO_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.TITOLO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigmaSeguitoVO.getUtente() == null || enigmaSeguitoVO.getUtente().isEmpty())
            return new ValidatorResponse(false, EnigmiSeguitiConstants.UTENTE_IS_NULL_OR_EMPTY.getCodice(),EnigmiSeguitiConstants.UTENTE_IS_NULL_OR_EMPTY.getDescrizione());


        return  new ValidatorResponse(true, EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getCodice(), EnigmiSeguitiConstants.ENIGMASEGUITO_OK.getDescrizione());
    }

}
