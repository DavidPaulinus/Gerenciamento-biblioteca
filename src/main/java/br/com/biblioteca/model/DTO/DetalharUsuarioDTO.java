package br.com.biblioteca.model.DTO;

import java.time.LocalDate;

import br.com.biblioteca.model.Usuario;

public record DetalharUsuarioDTO(String nome, LocalDate emprestimo, LocalDate devolucao, Long livroId, String livroNome) {
	public DetalharUsuarioDTO(Usuario use) {
		this(use.getNome(), use.getEmprestimo(), use.getDevolucao(), use.getLivro() == null ? null : use.getLivro().getId(), use.getLivro() == null ? null : use.getLivro().getNome());
	}
}
