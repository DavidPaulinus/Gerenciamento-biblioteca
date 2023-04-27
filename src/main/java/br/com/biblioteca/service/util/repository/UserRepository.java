package br.com.biblioteca.service.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.biblioteca.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
