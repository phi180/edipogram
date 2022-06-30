package asw.edipogram.enigmiseguiti.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enigmiseguiti")
@Data
@NoArgsConstructor
public class EnigmaSeguito {

    @EmbeddedId
    private EnigmaSeguitoPK enigmaSeguitoPK;

    private String autoreEnigma;
    private String tipoEnigma;
    private String tipoSpecificoEnigma;
    private String titoloEnigma;
    private String[] testoEnigma;

}
