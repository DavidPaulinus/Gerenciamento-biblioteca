package br.com.biblioteca.model;

import java.time.LocalDate;

import br.com.biblioteca.model.DTO.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate emprestimo;
	private LocalDate devolucao;
	@ManyToOne
	private Livro livro;

	public Usuario(UserDTO dto) {
		this.nome = dto.nome();
		this.emprestimo = dto.emprestimo();
		this.devolucao = dto.devolucao();
		this.livro = dto.livro();
	}

	public void atualizar(UserDTO dto) {
		this.nome = dto.nome();
		this.emprestimo = dto.emprestimo();
		this.devolucao = dto.devolucao();
		this.livro = dto.livro();
	}
}
