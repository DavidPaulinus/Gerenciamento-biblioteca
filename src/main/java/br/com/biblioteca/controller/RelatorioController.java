package br.com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.model.DTO.RelatorioDTO;
import br.com.biblioteca.service.RelatorioService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
	@Autowired
	private RelatorioService serv;
	
	@GetMapping
	public ResponseEntity<Page<RelatorioDTO>> relatorio(){
		return ResponseEntity.ok(serv.relatorio());
	}
}
