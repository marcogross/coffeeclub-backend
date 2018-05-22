package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.domain.Funcionario;
import com.example.demo.domain.PedidoFuncionario;

//Define os dados que eu quero trafegar quando forem feitas operações básicas de PedidoFuncionario
public class PedidoFuncionarioDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private Funcionario funcionario;
	private Double valorTotal;
	
	public PedidoFuncionarioDTO(PedidoFuncionario obj) {
		super();
		id = obj.getId();
		data = obj.getData();
		funcionario = obj.getFuncionario();
		valorTotal = obj.getValorTotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	/*
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	*/

	public Double getValorTotal() {
		//Double aux = 0.0;
		/*
		for(ItemPedidoFuncionario item: this.getItenspedidofuncionario()) {
			aux += item.getQuantidade() * item.getCafe().getPreco();
		}
		*/
		return valorTotal;
		
	}


	
	
	
}
