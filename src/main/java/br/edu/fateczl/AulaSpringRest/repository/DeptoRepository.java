package br.edu.fateczl.AulaSpringRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.AulaSpringRest.model.entity.Depto;

public interface DeptoRepository extends JpaRepository<Depto, Integer> {

}
