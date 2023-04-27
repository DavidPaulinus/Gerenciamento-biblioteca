package br.com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.model.DTO.UserDTO;
import br.com.biblioteca.service.util.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public Page<Usuario> listar() {
		return new PageImpl<>(repo.findAll());
	}

	public Usuario detalhar(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Id inválido."));
	}

	public Page<Usuario> deletar(Long id) {
		repo.deleteById(id);
		
		return listar();
	}

	public Usuario cadatrar(UserDTO dto) {
		var user = new Usuario(dto);
		repo.save(user);
		
		return user;
	}

	public Usuario editar(UserDTO dto, Long id) {
		var user = detalhar(id);
		user.atualizar(dto);
		
		return user;
	}
}
