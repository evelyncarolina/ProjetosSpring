package com.lojadegames.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojadegames.games.model.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long> {
	
	//Para que o usuario possa escrever com letras maiuscula e minuscula
	List<Produto> findAllByNomeContainingIgnoreCase(String nome);

	List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	//List<Produto> findAllByDescricaoContainingIgnoreCase1(String descricao);

}
