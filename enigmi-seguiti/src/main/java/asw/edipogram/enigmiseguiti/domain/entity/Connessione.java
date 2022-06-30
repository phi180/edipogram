package asw.edipogram.enigmiseguiti.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Connessione {

	@Id
	@SequenceGenerator(name="ID_CONNESSIONE_GEN",sequenceName = "CONNESSIONE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ID_CONNESSIONE_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String utente;
	private String tipo;

	public Connessione(String utente, String tipo) {
		this.utente = utente;
		this.tipo = tipo;
	}
}
