package com.lojafarmacia.farmacia.repository;

import java.util.Optional;

import javax.swing.Spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojafarmacia.farmacia.model.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findAllByremedioCabecaContainingIgnoreCase(Spring remedioCabeca);

	
}
