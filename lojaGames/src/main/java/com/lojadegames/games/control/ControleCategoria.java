package com.lojadegames.games.control;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lojadegames.games.model.Categoria;
import com.lojadegames.games.repository.RepositorioCategoria;

public class ControleCategoria {
	
	private @Autowired RepositorioCategoria repositorio;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos()
	{
		List<Categoria> objetoLista = repositorio.findAll();
		
		if (objetoLista.isEmpty()) 
		{
			return ResponseEntity.status(204).build();
		} 
		
		else 
		{
			return ResponseEntity.status(200).body(objetoLista);
		}
		
	}
	
	//Buscar por Identidade da categoria
	@GetMapping("/id/{id_categoria}") 
	public ResponseEntity<Categoria> buscarId(@PathVariable(value = "id_categoria") Long idCategoria)
	{
		Optional<Categoria> objetoCategoria = repositorio.findById(idCategoria);
		
		//Se o produto estiver presente, retorna o produto
		if(objetoCategoria.isPresent())
		{
			return ResponseEntity.status(200).body(objetoCategoria.get());
		}
		//Se a categoria não existir apresenta esse status
		else
		{
			return ResponseEntity.status(204).build();
		}
	}
	
	//Salvar uma nova categoria
	@PostMapping("/salvar") //Salvar nova categoria
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria novaCategoria) 
	{
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}
	
	//Buscar por tipo da categoria
	@GetMapping("/tipo/{tipo}") 
	public ResponseEntity<Categoria> buscarTipo(@PathVariable(value = "tipo") String tipo)
	{
		Optional<Categoria> objetoCategoria = repositorio.findAllByTipoContainingIgnoreCase(tipo);
		
		//Se o produto estiver presente, retorna o produto
		if(objetoCategoria.isPresent())
		{
			return ResponseEntity.status(200).body(objetoCategoria.get());
		}
		//Se a categoria não existir apresenta esse status
		else
		{
			return ResponseEntity.status(204).build();
		}
	}
	
	//Buscar por prime
	@GetMapping("/prime") 
	public ResponseEntity<List<Categoria>> buscarPrime(@PathVariable(value = "prime") Boolean prime)
	{
		List<Categoria> objetoPrime = repositorio.findAll();
		
		if (objetoPrime.isEmpty()) 
		{
			return ResponseEntity.status(204).build();
		} 
		
		else 
		{
			return ResponseEntity.status(200).body(objetoPrime);
		}
		
	}
	//Fazer uma atualização
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria categoriaParaAtualizar)
	{
		return ResponseEntity.status(201).body(repositorio.save(categoriaParaAtualizar));
	}
		
	//Deletar uma categoria
	@DeleteMapping("/deletar/{idCategoria}")
	public void Delete (@PathVariable (value = "idCategoria") Long idCategoria) {
		repositorio.deleteById(idCategoria); 
	}

}


