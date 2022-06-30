package asw.edipogram.enigmiseguiti.domain.repository;

import asw.edipogram.enigmiseguiti.domain.entity.Enigma;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EnigmiRepository extends CrudRepository<Enigma,Long> {

    Collection<Enigma> findEnigmaByTipo(String tipo);

    @Query("SELECT e FROM Enigma e WHERE e.tipo in (?1)")
    Collection<Enigma> findEnigmasByTipo(Collection<String> tipi);

}
