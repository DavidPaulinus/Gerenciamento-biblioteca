package br.com.biblioteca.model.DTO;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDTO(
		@NotBlank
		String nome,
		@NotBlank
		String descricao,
		@NotNull
		@JsonFormat(pattern = "dd/MM/yyyy")
		LocalDate dataPublicacao,
		@NotNull
		Integer quantidade,
		@NotNull
		Integer estoque,
		@NotBlank
		String localizacao,
		List<Usuario> emprestado) {

}
