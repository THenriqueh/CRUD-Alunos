package com.projetonttdata.CRUDAlunos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetonttdata.CRUDAlunos.entities.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@GetMapping
	public ResponseEntity <List<Aluno>> findAll(){
		List<Aluno> list = new ArrayList<>();
		list.add(new Aluno(1, "Pedro", "Recife"));
		list.add(new Aluno(2, "Maria", "Olinda"));
		return ResponseEntity.ok().body(list);
		
	}
	
	

}
