package br.com.biblioteca.model;

import java.time.LocalDate;
import java.util.List;

import br.com.biblioteca.model.DTO.LivroDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_livro")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataPublicacao;
	private Integer quantidade;
	private Integer estoque;
	private String localizacao;
	@OneToMany
	private List<Usuario> emprestado;

	public Livro(LivroDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.dataPublicacao = dto.dataPublicacao();
		this.quantidade = dto.quantidade();
		this.estoque = dto.estoque();
		this.localizacao = dto.localizacao();
		this.emprestado = null;
	}

	public void atualizar(LivroDTO dto) {
		this.nome = dto.nome();
		this.descricao = dto.descricao();
		this.dataPublicacao = dto.dataPublicacao();
		this.quantidade = dto.quantidade();
		this.estoque = dto.estoque();
		this.localizacao = dto.localizacao();
		this.emprestado = dto.emprestado();
	}
}
