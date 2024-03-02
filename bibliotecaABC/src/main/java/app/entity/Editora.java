package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEditora;
	
	@NotNull(message = "Este campo não pode ser nulo")
	private String nome;
	private String endereco;
	private String telefone;
	
	@OneToMany(mappedBy = "editora")
    private List<Livro> livros;
}
