package asw.edipogram.enigmiseguiti.domain.repository;

import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguito;
import asw.edipogram.enigmiseguiti.domain.entity.EnigmaSeguitoPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EnigmiSeguitiRepository extends CrudRepository<EnigmaSeguito, EnigmaSeguitoPK> {

    Collection<EnigmaSeguito> findAllByEnigmaSeguitoPKUtente(String utente);

}
