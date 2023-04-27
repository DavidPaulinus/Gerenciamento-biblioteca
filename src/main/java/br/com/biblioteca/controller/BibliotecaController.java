package br.com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.biblioteca.model.DTO.DetalharLivroDTO;
import br.com.biblioteca.model.DTO.LivroDTO;
import br.com.biblioteca.service.LivroService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
	@Autowired
	private LivroService serv;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DetalharLivroDTO> adicionarLivro(@RequestBody LivroDTO dto, UriComponentsBuilder uri) {
		var liv = serv.adicionarLivro(dto);
		
		return ResponseEntity.created(uri.path("/biblioteca").buildAndExpand(liv.getId()).toUri()).body(new DetalharLivroDTO(liv));
	}
	
	@GetMapping
	public ResponseEntity<Page<DetalharLivroDTO>> listarLivros(){
		return ResponseEntity.ok(serv.listarLivros().map(DetalharLivroDTO::new));
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalharLivroDTO> detalharLivroPorId(@PathVariable Long id){
		return ResponseEntity.ok(new DetalharLivroDTO(serv.detalharLivroPorId(id)));
	}
}
