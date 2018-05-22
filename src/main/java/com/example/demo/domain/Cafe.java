package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Cafe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String miniDescricao;
	@Lob
	@Column(columnDefinition="longtext")
	private String descricao;
	private double preco;
	private Integer intensidade;
	private String perfilAromatico;
	private String variedade;
	@Lob
	@Column
	private String imagem;
	/*
	//Muitos cafes podem estar em uma mesma categoria
	@JsonIgnore
	@ManyToOne
	private Categoria categoria;
	*/
	
	//Um cafe pode ser solicitado por N itemPedidoFuncionario
	@OneToMany(mappedBy = "cafe")
	private List<ItemPedidoFuncionario> itenspedidofuncionario = new ArrayList<>();
	
	
	
	
	public Cafe() {}
	//id, nome [miniDescricao, [descricao], preco, intensidade, perfilAromatico, variedade, imagem
	public Cafe(Integer id, String nome, String miniDescricao, String descricao, double preco, 
			Integer intensidade, String perfilAromatico, String variedade, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.miniDescricao = miniDescricao;
		this.descricao = descricao;
		this.preco = preco;
		this.intensidade = intensidade;
		this.perfilAromatico = perfilAromatico;
		this.variedade = variedade;
		this.imagem = imagem;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Integer intensidade) {
		this.intensidade = intensidade;
	}

	public String getPerfilAromatico() {
		return perfilAromatico;
	}

	public void setPerfilAromatico(String perfilAromatico) {
		this.perfilAromatico = perfilAromatico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/*
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	*/
	
	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	public String getMiniDescricao() {
		return miniDescricao;
	}
	public void setMiniDescricao(String miniDescricao) {
		this.miniDescricao = miniDescricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
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
		Cafe other = (Cafe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
