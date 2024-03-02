package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Autor {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAutor;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String nome;
	private String cpf;
	private Integer idade;
	
	@ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
}
