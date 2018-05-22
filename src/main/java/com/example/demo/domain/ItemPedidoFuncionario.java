package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemPedidoFuncionario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer quantidade;
	//N ItensPedidoFuncionario podem ser pedidos por um Funcionario
	@JsonIgnore
	@ManyToOne
	private Funcionario funcionario;
	//Muitos itensPedidoFuncionario podem ser solicitados em um mesmo pedidoFuncionario
	@JsonIgnore
	@ManyToOne
	private PedidoFuncionario pedidofuncionario;
	//Muitos itensPedidoFuncionario podem estar relacionados a um mesmo cafe
	//@JsonIgnore
	@ManyToOne
	private Cafe cafe;
	
	

	public ItemPedidoFuncionario() {}
	
	public ItemPedidoFuncionario(Integer id, Funcionario funcionario, PedidoFuncionario pedidofuncionario, Cafe cafe, Integer quantidade) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.pedidofuncionario = pedidofuncionario;
		this.cafe = cafe;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public PedidoFuncionario getPedidofuncionario() {
		return pedidofuncionario;
	}

	public void setPedidofuncionario(PedidoFuncionario pedidofuncionario) {
		this.pedidofuncionario = pedidofuncionario;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}



	
	
}
