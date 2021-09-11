package com.lojadegames.games.control;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.games.model.Produto;
import com.lojadegames.games.repository.RepositorioProduto;

@RestController
@RequestMapping("/produto")
public class ControleProduto {

	private @Autowired RepositorioProduto repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> buscarTodos()
	{
		List<Produto> objetoProduto = repositorio.findAll();
		
		if (objetoProduto.isEmpty()) 
		{
			return ResponseEntity.status(204).build();
		} 
		
		else 
		{
			return ResponseEntity.status(200).body(objetoProduto);
		}	
	}
	
	@GetMapping("/{id_produto}") 
	public ResponseEntity<Produto> buscarId(@PathVariable(value = "id_produto") Long idProduto)
	{
		Optional<Produto> objetoProduto = repositorio.findById(idProduto);
		
		//Se o produto estiver presente, retorna o produto
		if(objetoProduto.isPresent())
		{
			return ResponseEntity.status(200).body(objetoProduto.get());
		}
		//Se a produto não existir apresenta esse status
		else
		{
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/descricao/{descricao_produto}")
	public ResponseEntity<List<Produto>> adiocionaDecricao(@PathVariable(value = "descricao_produto") String descricao) 
		{
		List<Produto> objetoDescricao = repositorio.findAllByDescricaoContainingIgnoreCase(descricao);

		if (objetoDescricao.isEmpty()) {
			return ResponseEntity.status(204).build();
		}

		else {
			return ResponseEntity.status(200).body(objetoDescricao);
		}
		
	}
	
	//Fazer uma atualização
	@PutMapping("/atualizar")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto produtoAtualizar)
		{
			return ResponseEntity.status(201).body(repositorio.save(produtoAtualizar));
		}
		
		//Deletar uma Produto
	@DeleteMapping("/deletar/{idCategoria}")
	public void Delete (@PathVariable Long idProduto) 
		{
			repositorio.deleteById(idProduto); 
		}
	
	
}
