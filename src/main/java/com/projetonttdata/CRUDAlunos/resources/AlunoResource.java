package com.projetonttdata.CRUDAlunos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService service;

	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id) {
		AlunoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> update(@PathVariable Integer id, @RequestBody AlunoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
