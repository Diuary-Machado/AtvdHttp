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

import app.entity.Editora;
import app.service.EditoraService;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {

	 @Autowired
	 public EditoraService editoraService;
	 
	 @PostMapping("/save")
	 public ResponseEntity<String> save(@RequestBody Editora editora){
		 
		 try {
			
			 String salvar = this.editoraService.save(editora);
			 return new ResponseEntity<>(salvar, HttpStatus.CREATED);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		 
	 }
	 
	 @GetMapping("/listAll")
	 public ResponseEntity<List<Editora>> listAll(){
		 
		 try {
			
			 List<Editora> lista = this.editoraService.listAll();
			 return new ResponseEntity<>(lista, HttpStatus.OK);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		 
	 }
	 
	 @GetMapping("/findById/{id}")
	 public ResponseEntity<Editora> findById(@PathVariable long id){
		 
		 try {
			
			 Editora editora = this.editoraService.findById(id);
			 return new ResponseEntity<>(editora, HttpStatus.OK);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		 
	 }
	 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<String> update(@PathVariable long id,@RequestBody Editora novaEditora){
		 
		 try {
			
			 String editora = this.editoraService.update(id, novaEditora);
			 return new ResponseEntity<String>(editora, HttpStatus.OK);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		 
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> delete(@PathVariable long id){
		 
		 try {
			
			 String mensagem = this.editoraService.delete(id);
			 return new ResponseEntity<>(mensagem, HttpStatus.OK);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		 
	 }
}
