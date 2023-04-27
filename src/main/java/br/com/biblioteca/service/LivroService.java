package br.com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.DTO.LivroDTO;
import br.com.biblioteca.service.util.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repo;
	
	public Livro adicionarLivro(LivroDTO dto) {
		var liv = new Livro(dto);
		repo.save(liv);
		
		return liv;
	}

	public Page<Livro> listarLivros() {
		return new PageImpl<>(repo.findAll());
	}

	public Livro detalharLivroPorId(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("ID inválido."));
	}

	public Livro editar(LivroDTO dto, Long id) {
		var liv = detalharLivroPorId(id);
		liv.atualizar(dto);
		
		return liv;
	}

	public Page<Livro> excluirLivroPorId(Long id) {
		repo.deleteById(id);
		
		return listarLivros();
	}

}
