package com.lojafarmacia.farmacia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long categoria;
	private String remedioPressao;
	private String remedioCabeca;
	
	@OneToMany(mappedBy = "relacionador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"relacionador"})
	private List<Produto> produto = new ArrayList<>();
	
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public String getRemedioPressao() {
		return remedioPressao;
	}
	public void setRemedioPressao(String remedioPressao) {
		this.remedioPressao = remedioPressao;
	}
	public String getRemedioCabeca() {
		return remedioCabeca;
	}
	public void setRemedioCabeca(String remedioCabeca) {
		this.remedioCabeca = remedioCabeca;
	}
	
	
	
}
