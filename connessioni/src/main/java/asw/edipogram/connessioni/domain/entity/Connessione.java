package asw.edipogram.connessioni.domain.entity;

import javax.persistence.*; 

import lombok.*; 

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
		this(); 
		this.utente = utente; 
		this.tipo = tipo; 
	}
	
}
