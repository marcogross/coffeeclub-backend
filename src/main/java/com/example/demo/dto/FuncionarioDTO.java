package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.domain.Funcionario;

//Define os dados que eu quero trafegar quando forem feitas operações básicas de Funcionario
public class FuncionarioDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String setor;
	
	public FuncionarioDTO(Funcionario obj) {
		id = obj.getId();
		nome = obj.getNome();
		setor = obj.getSetor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	

}
