package br.com.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.model.DTO.RelatorioDTO;

@Service
public class RelatorioService {
	@Autowired
	private LivroService serv;

	public Page<RelatorioDTO> relatorio() {
		var livro = serv.listarLivros().getContent();
		List<RelatorioDTO> arr = new ArrayList<>();
		
		List<Long> userId = new ArrayList<>();
		List<String> userName = new ArrayList<>();
		for (int i = 0; i < livro.size(); i++) {
			
			var user = livro.get(i).getEmprestado();
			for(Usuario lista:user) {
				if(user != null) {
					userId.add(lista.getId());
					userName.add(lista.getNome());
				}
			}

			var liv = new RelatorioDTO(livro.get(i).getNome(), livro.get(i).getQuantidade(), livro.get(i).getEstoque(), userId, userName);

			arr.add(liv);
		}

		return new PageImpl<>(arr);
	}

}
