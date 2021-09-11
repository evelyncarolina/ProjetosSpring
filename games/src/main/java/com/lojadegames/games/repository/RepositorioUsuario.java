package com.lojadegames.games.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojadegames.games.model.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail (String email);
}
