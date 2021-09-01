package com.lojafarmacia.farmacia.control;

import java.util.List;
import java.util.Optional;

import javax.swing.Spring;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojafarmacia.farmacia.model.Categoria;
import com.lojafarmacia.farmacia.repository.RepositorioCategoria;

@RestController
@RequestMapping("/api/categoria")
public class ControleCategoria {

	private @Autowired RepositorioCategoria repositorio;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> objetoTodos = repositorio.findAll();

		if (objetoTodos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} 
		else {
			return ResponseEntity.status(200).body(objetoTodos);
		}

	}

	@GetMapping("{/id_categoria}")
	public ResponseEntity<Categoria> buscaId(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categoria> objetoCategoria = repositorio.findById(idCategoria);

		if (objetoCategoria.isPresent()) {
			return ResponseEntity.status(200).body(objetoCategoria.get());
		}

		else {
			return ResponseEntity.status(204).build();
		}
	}

	@PostMapping("/salva")
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria novaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}

	@GetMapping("/remedioCabeca/{remedioCabeca}")
	public ResponseEntity<Categoria> buscarCabeca(@PathVariable(value = "remedioCabeca") Spring remedioCabeca) {
		Optional<Categoria> objetoCabeca = repositorio.findAllByremedioCabecaContainingIgnoreCase(remedioCabeca);

		if (objetoCabeca.isPresent()) {
			return ResponseEntity.status(200).body(objetoCabeca.get());
		}

		else {
			return ResponseEntity.status(204).build();
		}

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> atualizacao(@Valid @RequestBody Categoria atualizaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(atualizaCategoria));

	}
	
	@DeleteMapping("/deletar/{deletarId}")
	public void Delete (@PathVariable Long deletarId) {
		repositorio.deleteById(deletarId);
	}

}




