package com.projetonttdata.CRUDAlunos.services;

import com.projetonttdata.CRUDAlunos.dto.AlunoDTO;
import com.projetonttdata.CRUDAlunos.entities.Aluno;
import com.projetonttdata.CRUDAlunos.repositories.AlunoRepository;
import com.projetonttdata.CRUDAlunos.resources.Pages;
import com.projetonttdata.CRUDAlunos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Page<AlunoDTO> findAll(Pages pages) {

		PageRequest pageRequest = PageRequest.of(
				pages.getPage(),
				pages.getSize(),
				Sort.Direction.ASC,
				"name");

		Page<Aluno> alunos = repository.findAll(pageRequest);

		final List<AlunoDTO> alunosResponse = alunos.stream()
				.map(AlunoDTO::new)
				.collect(Collectors.toList());

		return new PageImpl<>(
				alunosResponse,
				pageRequest, pages.getSize());
	}


	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(Pages pages) {
		PageRequest pageRequest = PageRequest.of(
				pages.getPage(),
				pages.getSize(),
				Sort.Direction.ASC,
				"name");

		return repository.search(
				pages.getName().toLowerCase(),
				pageRequest);
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
		entity.setEmail(dto.getEndereco());
		entity = repository.save(entity);
		return new AlunoDTO(entity);

	}

	@Transactional
	public AlunoDTO update(Integer id, AlunoDTO dto) {
		try {
			Aluno entity = new Aluno();
			entity.setName(dto.getName());
			entity.setEmail(dto.getEndereco());
			entity = repository.save(entity);
			return new AlunoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Aluno de id " + id + "não encontrado");
		}
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Aluno de id " + id + "não encontrado");
		}
	}


}
