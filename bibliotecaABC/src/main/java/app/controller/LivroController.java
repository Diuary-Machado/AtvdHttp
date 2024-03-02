package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	public LivroService livroService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Livro livro){

		try {

			String saved = this.livroService.save(livro);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Livro>> listAll(){

		try {

			List<Livro> lista = this.livroService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> findByid(@PathVariable long id){

		try {

			Livro livros = this.livroService.findById(id);
			return new ResponseEntity<>(livros, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Livro novoLivro,@RequestBody long id){

		try {

			String livro = this.livroService.update(id, novoLivro);
			return new ResponseEntity<String>(livro, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){

		try {

			String erro = this.livroService.delete(id);
			return new ResponseEntity<>(erro, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

}
