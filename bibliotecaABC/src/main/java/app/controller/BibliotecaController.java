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

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

	@Autowired
	public BibliotecaService bibliotecaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca){

		try {

			String salvar = this.bibliotecaService.save(biblioteca);
			return new ResponseEntity<>(salvar, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Biblioteca>> listAll(){
		
		try {
			
			List<Biblioteca> lista = this.bibliotecaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Biblioteca> findById(@PathVariable long id){
		
		try {
			
			Biblioteca biblioteca = this.bibliotecaService.findById(id);
			return new ResponseEntity<>(biblioteca, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Biblioteca biblioteca, @PathVariable long id) {
		
		try {
			
			String mensagem = this.bibliotecaService.update(id, biblioteca);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		
		try {
			
			String erro = this.bibliotecaService.delete(id);
			return new ResponseEntity<>(erro, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
}
