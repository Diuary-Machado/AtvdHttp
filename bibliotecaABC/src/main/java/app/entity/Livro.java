package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String issn;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String titulo;
	private String sinopse;
	private Integer ano;
	private Integer numPag;
	
	@ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

	
	 @ManyToOne
	    @JoinColumn(name = "editora_id")
	    private Editora editora;

	 @ManyToMany
	    @JoinTable(
	        name = "livro_autor",
	        joinColumns = @JoinColumn(name = "livro_id"),
	        inverseJoinColumns = @JoinColumn(name = "autor_id")
	    )
	    private List<Autor> autores;

	
	
}
