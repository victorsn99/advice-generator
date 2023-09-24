package com.api.advice.advicesGenerator.controller;

import com.api.advice.advicesGenerator.model.Conselho;
import com.api.advice.advicesGenerator.service.ConselhoService;
import com.api.advice.advicesGenerator.service.UsuarioService;
import com.api.advice.advicesGenerator.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 */
@RestController
@RequestMapping("usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ConselhoService conselhoService;

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> buscarTodos() {
		return ResponseEntity.ok(usuarioService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
		usuarioService.inserir(usuario);
		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		usuarioService.deletar(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/gerar-e-salvar-conselho/{usuarioId}")
	public ResponseEntity<Conselho> gerarESalvarConselho(@PathVariable Long usuarioId) {
		return ResponseEntity.ok(conselhoService.gerarESalvarConselho(usuarioId));
	}

	@PutMapping("/buscar-conselho-por-id-e-salvar/{usuarioId}/{conselhoId}")
	public ResponseEntity<Conselho> salvarConselho(@PathVariable Long usuarioId, @PathVariable Long conselhoId) {
		return ResponseEntity.ok(conselhoService.salvarConselho(usuarioId, conselhoId));
	}
}
