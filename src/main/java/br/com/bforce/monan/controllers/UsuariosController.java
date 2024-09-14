package br.com.bforce.monan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.Usuario;
import br.com.bforce.monan.model.UsuarioDTO;
import br.com.bforce.monan.service.IUsuarioService;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin
public class UsuariosController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrarNovaUsuario(@RequestBody UsuarioDTO novoUsuarioDTO) {
		Usuario Usuario = service.criarNovoUsuario(new Usuario(novoUsuarioDTO));
		if (Usuario != null) {
			return ResponseEntity.status(201).body(Usuario);
		}
		return ResponseEntity.badRequest().build();
	}
}
