package br.com.biblioteca.model.DTO;

import java.time.LocalDate;

import br.com.biblioteca.model.Livro;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
		@NotBlank
		String nome,
		LocalDate emprestimo,
		LocalDate devolucao,
		Livro livro) {

}
