package br.com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
