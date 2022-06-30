package asw.edipogram.enigmiseguiti.domain.validator;

public interface Validator<T> {

    ValidatorResponse isValid(T t);

}
