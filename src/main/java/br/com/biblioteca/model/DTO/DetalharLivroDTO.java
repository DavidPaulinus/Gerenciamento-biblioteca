package br.com.biblioteca.model.DTO;

import java.time.LocalDate;
import java.util.List;

import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

public record DetalharLivroDTO(String nome, String descricao, LocalDate dataPublicacao, Integer quantidade, Integer estoque, String localizacao, List<Usuario> emprestado) {
	public DetalharLivroDTO(Livro li) {
		this(li.getNome(), li.getDescricao(), li.getDataPublicacao(), li.getQuantidade(), li.getEstoque(), li.getLocalizacao(), li.getEmprestado());
	}
}
