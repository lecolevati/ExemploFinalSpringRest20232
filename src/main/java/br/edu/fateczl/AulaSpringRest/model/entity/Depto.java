package br.edu.fateczl.AulaSpringRest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "depto")
public class Depto {

	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;
	
}
