package com.projetonttdata.CRUDAlunos.dto;

import java.io.Serializable;

import com.projetonttdata.CRUDAlunos.entities.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;

	public AlunoDTO() {

	}

	public AlunoDTO(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;

	}
	
	public AlunoDTO(Aluno entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
