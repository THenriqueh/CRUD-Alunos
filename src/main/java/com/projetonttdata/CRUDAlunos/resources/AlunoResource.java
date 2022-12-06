package com.projetonttdata.CRUDAlunos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity <List<AlunoDTO>> findAll(){
		List<AlunoDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	

}
