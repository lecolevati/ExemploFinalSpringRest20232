package br.edu.fateczl.AulaSpringRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.AulaSpringRest.model.dto.DeptoDTO;
import br.edu.fateczl.AulaSpringRest.model.entity.Depto;
import br.edu.fateczl.AulaSpringRest.repository.DeptoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class DeptoController implements ICRUDController<DeptoDTO> {

	@Autowired
	private DeptoRepository dRep;

	@Override
	@GetMapping("/depto")
	public List<DeptoDTO> lista() {
		List<Depto> deptos = dRep.findAll();
		List<DeptoDTO> deptosDTO = 
				converteListaDeptoListaDeptoDTO(deptos);
		return deptosDTO;
	}

	@Override
	@GetMapping("/depto/{codDepto}")
	public ResponseEntity<DeptoDTO> busca
			(@PathVariable(value = "codDepto") int cod) {
		Depto depto = dRep.findById(cod).orElseThrow(
				() -> new ResourceNotFoundException(
						"Código inválido"));
		DeptoDTO deptoDTO = converteDeptoDeptoDTO(depto);
		return ResponseEntity.ok().body(deptoDTO);
	}

	@Override
	@PostMapping("/depto")
	public ResponseEntity<String> adiciona(@Valid @RequestBody DeptoDTO deptoDTO) {
		Depto depto = converteDeptoDTODepto(deptoDTO);
		dRep.save(depto);
		String saida = "Depto adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/depto")
	public ResponseEntity<String> atualiza(@Valid @RequestBody DeptoDTO deptoDTO) {
		Depto depto = converteDeptoDTODepto(deptoDTO);
		dRep.save(depto);
		String saida = "Depto atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/depto")
	public ResponseEntity<String> exclui(@Valid @RequestBody DeptoDTO deptoDTO) {
		Depto depto = converteDeptoDTODepto(deptoDTO);
		dRep.delete(depto);
		String saida = "Depto excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	private List<DeptoDTO> converteListaDeptoListaDeptoDTO(List<Depto> listaDepto) {
		List<DeptoDTO> listaDeptoDTO = new ArrayList<>();
		for (Depto depto : listaDepto) {
			DeptoDTO deptoDTO = new DeptoDTO();
			deptoDTO.setCodigo(depto.getCodigo());
			deptoDTO.setNome(depto.getNome());
			listaDeptoDTO.add(deptoDTO);
		}
		return listaDeptoDTO;
	}

	private DeptoDTO converteDeptoDeptoDTO(Depto depto) {
		DeptoDTO deptoDTO = new DeptoDTO();
		deptoDTO.setCodigo(depto.getCodigo());
		deptoDTO.setNome(depto.getNome());
		return deptoDTO;
	}

	private Depto converteDeptoDTODepto(DeptoDTO deptoDTO) {
		Depto depto = new Depto();
		depto.setCodigo(deptoDTO.getCodigo());
		depto.setNome(deptoDTO.getNome());
		return depto;
	}


}
