package br.com.biblioteca.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
