package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PedidoFuncionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	
	//Um pedidoFuncionario pode ter N itemPedidoFuncionario
	@OneToMany(mappedBy = "pedidofuncionario", targetEntity = ItemPedidoFuncionario.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ItemPedidoFuncionario> itenspedidofuncionario = new ArrayList<>();
	
	//N pedidoFuncionario podem ser feitos por um funcionario
	@JsonIgnore
	@ManyToOne
	private Funcionario funcionario;
	@Transient
	private Double valorTotal;
	
	
	
	public PedidoFuncionario() {}


	public PedidoFuncionario(Integer id, Funcionario funcionario) {
		super();
		this.id = id;
		this.funcionario = funcionario;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public List<ItemPedidoFuncionario> getItenspedidofuncionario() {
		return itenspedidofuncionario;
	}


	public void setItenspedidofuncionario(List<ItemPedidoFuncionario> itenspedidofuncionario) {
		this.itenspedidofuncionario = itenspedidofuncionario;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoFuncionario other = (PedidoFuncionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Double getValorTotal() {
		Double aux = 0.0;
		
		for(ItemPedidoFuncionario item: this.getItenspedidofuncionario()) {
			aux += item.getQuantidade() * item.getCafe().getPreco();
		}
		
		return aux;
	}
	
	
	
	
}
