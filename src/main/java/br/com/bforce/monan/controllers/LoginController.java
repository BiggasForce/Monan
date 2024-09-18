package br.com.bforce.monan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.AcessoDTO;
import br.com.bforce.monan.model.AutenticacaoDTO;
import br.com.bforce.monan.model.RegisterDTO;
import br.com.bforce.monan.service.IAutenticacaoService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	private IAutenticacaoService autenticacaoService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AutenticacaoDTO autenticacaoDTO) {
		AcessoDTO acesso = autenticacaoService.login(autenticacaoDTO);
		
		if (acesso == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não encontrado");
		}
		return ResponseEntity.ok( acesso );
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> cadastrarNovaUsuario(@RequestBody RegisterDTO novoUsuarioDTO) {
		return ResponseEntity.ok( autenticacaoService.register(novoUsuarioDTO) );
	}
	
	@PostMapping(value = "/logout")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok().build();
	}
}
