package asw.edipogram.enigmiseguiti.domain.validator;

import asw.edipogram.enigmiseguiti.domain.enums.EnigmiConstants;
import asw.edipogram.enigmiseguiti.domain.vo.EnigmaVO;
import org.springframework.stereotype.Component;

@Component
public class EnigmaValidator implements Validator<EnigmaVO> {

    @Override
    public ValidatorResponse isValid(EnigmaVO enigma) {
        if(enigma == null)
            return new ValidatorResponse(false, EnigmiConstants.ENIGMA_IS_NULL.getCodice(),EnigmiConstants.ENIGMA_IS_NULL.getDescrizione());
        if(enigma.getAutore() == null || enigma.getAutore().isEmpty())
            return new ValidatorResponse(false, EnigmiConstants.AUTORE_IS_NULL_OR_EMPTY.getCodice(),EnigmiConstants.AUTORE_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigma.getTipo() == null || enigma.getTipo().isEmpty())
            return new ValidatorResponse(false, EnigmiConstants.TIPO_IS_NULL_OR_EMPTY.getCodice(),EnigmiConstants.TIPO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigma.getTipoSpecifico() == null || enigma.getTipoSpecifico().isEmpty())
            return new ValidatorResponse(false, EnigmiConstants.TIPOSPECIFICO_IS_NULL_OR_EMPTY.getCodice(),EnigmiConstants.TIPOSPECIFICO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigma.getTitolo() == null || enigma.getTitolo().isEmpty())
            return new ValidatorResponse(false, EnigmiConstants.TITOLO_IS_NULL_OR_EMPTY.getCodice(),EnigmiConstants.TITOLO_IS_NULL_OR_EMPTY.getDescrizione());
        if(enigma.getTesto() == null || enigma.getTesto().length==0)
            return new ValidatorResponse(false, EnigmiConstants.TESTO_IS_NULL_OR_EMPTY.getCodice(),EnigmiConstants.TESTO_IS_NULL_OR_EMPTY.getDescrizione());

        return new ValidatorResponse(true,EnigmiConstants.ENIGMA_OK.getCodice(),EnigmiConstants.ENIGMA_OK.getDescrizione());
    }


}
