package com.projetonttdata.CRUDAlunos.dto;

import java.io.Serializable;

import com.projetonttdata.CRUDAlunos.entities.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String endereco;

	public AlunoDTO() {

	}

	public AlunoDTO(Integer id, String name, String endereco) {
		this.id = id;
		this.name = name;
		this.endereco = endereco;

	}
	
	public AlunoDTO(Aluno entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.endereco = entity.getEndereço();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
