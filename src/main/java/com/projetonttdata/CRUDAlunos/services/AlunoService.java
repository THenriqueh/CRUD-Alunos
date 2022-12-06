package com.projetonttdata.CRUDAlunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetonttdata.CRUDAlunos.entities.Aluno;
import com.projetonttdata.CRUDAlunos.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public List<Aluno> findAll() {
		return repository.findAll();
	}

}
