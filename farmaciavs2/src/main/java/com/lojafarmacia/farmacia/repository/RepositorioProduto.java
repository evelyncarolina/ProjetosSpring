package com.lojafarmacia.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojafarmacia.farmacia.model.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long>{

	List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}
