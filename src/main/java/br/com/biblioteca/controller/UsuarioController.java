package br.com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.biblioteca.model.DTO.DetalharUsuarioDTO;
import br.com.biblioteca.model.DTO.UserDTO;
import br.com.biblioteca.service.UserService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	@Autowired
	private UserService serv;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DetalharUsuarioDTO> cadastrarUsuario(@RequestBody UserDTO dto, UriComponentsBuilder uri){
		var user = serv.cadatrar(dto);
		
		return ResponseEntity.created(uri.path("/user").buildAndExpand(user.getId()).toUri()).body(new DetalharUsuarioDTO(user));
	}
	
	@GetMapping
	public ResponseEntity<Page<DetalharUsuarioDTO>> listarUsuarios(){
		return ResponseEntity.ok(serv.listar().map(DetalharUsuarioDTO::new));
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalharUsuarioDTO> detalharUser(@PathVariable Long id){
		return ResponseEntity.ok(new DetalharUsuarioDTO(serv.detalhar(id)));
	}
	
	@PutMapping("/{id}]")
	@Transactional
	public ResponseEntity<DetalharUsuarioDTO> editarUser(@RequestBody UserDTO dto, @PathVariable Long id){
		var user = serv.editar(dto, id);
		
		return ResponseEntity.ok(new DetalharUsuarioDTO(user));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Page<DetalharUsuarioDTO>> deletarUser(@PathVariable Long id){
		return ResponseEntity.ok(serv.deletar(id).map(DetalharUsuarioDTO::new));
	}
}
