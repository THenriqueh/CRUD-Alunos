package com.projetonttdata.CRUDAlunos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.entities.Aluno;
import com.projetonttdata.CRUDAlunos.repositories.AlunoRepository;
import com.projetonttdata.CRUDAlunos.services.exceptions.EntityNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Transactional(readOnly = true)
	public List<AlunoDTO> findAll() {

		List<Aluno> list = repository.findAll();
		return list.stream().map(x -> new AlunoDTO(x)).collect(Collectors.toList());

	}
	
	@Transactional(readOnly = true)
	public AlunoDTO findById(Integer id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity not found!"));	
		return new AlunoDTO(entity);
	}

}
