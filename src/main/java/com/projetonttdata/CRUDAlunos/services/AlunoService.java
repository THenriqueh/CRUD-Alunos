package com.projetonttdata.CRUDAlunos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.entities.Aluno;
import com.projetonttdata.CRUDAlunos.repositories.AlunoRepository;
import com.projetonttdata.CRUDAlunos.services.exceptions.ResourceNotFoundException;

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
		Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		entity.setName(dto.getName());
		entity.setEndereço(dto.getEndereco());
		entity = repository.save(entity);
		return new AlunoDTO(entity);

	}
	@Transactional
	public AlunoDTO update(Integer id, AlunoDTO dto) {
		try {
			Aluno entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity.setEndereço(dto.getEndereco());
			entity = repository.save(entity);
			return new AlunoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found!" + id);
		}
	}

	public void delete(Integer id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

}
