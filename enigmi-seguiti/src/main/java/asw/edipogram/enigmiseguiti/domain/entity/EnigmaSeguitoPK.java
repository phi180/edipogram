package asw.edipogram.enigmiseguiti.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class EnigmaSeguitoPK implements Serializable {

    private static final long serialVersionUID = -4095756738460983679L;

    private String utente;

    private Long idEnigma;
}
