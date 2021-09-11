package com.lojadegames.games.control;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadegames.games.model.Usuario;
import com.lojadegames.games.model.utilites.UsuarioLogin;
import com.lojadegames.games.repository.RepositorioUsuario;
import com.lojadegames.games.servico.UsuarioService;

@RestController
@RequestMapping("usuario")
public class ControleUsuario {

	private @Autowired RepositorioUsuario repositorio;

	private @Autowired UsuarioService servicos;

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoSalvar = servicos.cadastrarUsuario(novoUsuario);

		if (objetoSalvar.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoSalvar.get());
		}
	}

	@PutMapping("/credenciais")
	public ResponseEntity<Object> credenciais(@Valid @RequestBody UsuarioLogin usuarioAutenticar) {
		Optional<?> objetoCredenciais = servicos.autenticador(usuarioAutenticar);

		if (objetoCredenciais.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {
			return ResponseEntity.status(201).body(objetoCredenciais.get());
		}
	}

}
