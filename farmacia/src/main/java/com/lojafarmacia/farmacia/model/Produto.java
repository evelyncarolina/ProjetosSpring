package com.lojafarmacia.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produto")
public class Produto {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
	private @NotBlank String nome;
	private @NotBlank Double preco;
	private @NotBlank String descricao;
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
