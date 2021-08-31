package com.lojadegames.games.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.games.model.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findAllByTipoContainingIgnoreCase(String tipo);

	
}
