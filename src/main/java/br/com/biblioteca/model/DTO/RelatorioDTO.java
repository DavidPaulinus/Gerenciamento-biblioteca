package br.com.biblioteca.model.DTO;

import java.util.List;

public record RelatorioDTO(String nome, Integer quantidade, Integer estoque, List<Long> userId, List<String> userNome) {

}
