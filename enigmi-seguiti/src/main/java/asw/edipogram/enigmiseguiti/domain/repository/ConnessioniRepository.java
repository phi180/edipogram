package asw.edipogram.enigmiseguiti.domain.repository;

import asw.edipogram.enigmiseguiti.domain.entity.Connessione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ConnessioniRepository extends CrudRepository<Connessione,Long> {

    Collection<Connessione> findConnessioneByUtente(String utente);

    @Query("SELECT c.utente FROM Connessione c WHERE c.tipo = ?1")
    Collection<String> findUtentiByTipo(String tipo);

}
