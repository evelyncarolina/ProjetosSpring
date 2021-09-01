package com.lojafarmacia.farmacia.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojafarmacia.farmacia.model.Produto;
import com.lojafarmacia.farmacia.repository.RepositorioProduto;

@RestController
@RequestMapping
public class ControleProduto {

	private @Autowired RepositorioProduto repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> buscarProduto(){
		List<Produto> objetoProduto = repositorio.findAll();
		
		if (objetoProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		else {
			return ResponseEntity.status(200).body(objetoProduto);
		}
	}
	
	@GetMapping("/id/{busca_id}")
	public ResponseEntity<Produto> buscaId(@PathVariable (value = "busca_id") Long idProduto){
		return repositorio.findById(idProduto)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto paraSalvar){
		return ResponseEntity.ok(repositorio.save(paraSalvar));
	}
	
	@DeleteMapping("/deletar/{deletarId}")
	public void deletarId(@PathVariable (value = "deletarId" ) Long paraDeletar) {
		repositorio.deleteById(paraDeletar);
	}
	
}













