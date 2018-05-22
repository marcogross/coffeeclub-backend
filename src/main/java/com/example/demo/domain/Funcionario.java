package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funcionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String setor;
	
	//Um Funcionário pode fazer N pedidos
	@OneToMany(mappedBy = "funcionario", targetEntity = PedidoFuncionario.class, fetch = FetchType.LAZY)
	private List<PedidoFuncionario> pedidosfuncionario = new ArrayList<>();
	//Um Funcionário pode solicitar N itens em seu PedidoFuncionario
	@OneToMany(mappedBy = "funcionario", targetEntity = ItemPedidoFuncionario.class, fetch = FetchType.LAZY)
	private List<ItemPedidoFuncionario> intenspedidofuncionario = new ArrayList<>();
	
	public Funcionario() {}

	public Funcionario(Integer id, String nome, String setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.setor = setor;
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

	public List<PedidoFuncionario> getPedidosfuncionario() {
		return pedidosfuncionario;
	}

	public void setPedidosfuncionario(List<PedidoFuncionario> pedidosfuncionario) {
		this.pedidosfuncionario = pedidosfuncionario;
	}
	
	

}
