package br.edu.fateczl.AulaSpringRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.AulaSpringRest.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
