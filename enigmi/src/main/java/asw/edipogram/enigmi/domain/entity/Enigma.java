package asw.edipogram.enigmi.domain.entity;

import javax.persistence.*; 

import lombok.*; 

/* Enigma, in formato completo. */ 
@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Enigma implements Comparable<Enigma> {

	@Id
	@SequenceGenerator(name="ID_ENIGMA_GEN",sequenceName = "ENIGMA_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "ID_ENIGMA_GEN", strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private Long id;
	private String autore; 
	private String tipo; 
	private String tipoSpecifico; 
	private String titolo;
	private String[] testo; 
	private String[] soluzione; 
	
	public Enigma(String autore, String tipo, String tipoSpecifico, String titolo, String[] testo, String[] soluzione) {
		this(); 
		this.autore = autore; 
		this.tipo = tipo; 
		this.tipoSpecifico = tipoSpecifico; 
		this.titolo = titolo; 
		this.testo = testo; 
		this.soluzione = soluzione; 
	}

	@Override
	public int compareTo(Enigma other) {
		return this.id.compareTo(other.id); 
	}
	
}
