package br.com.bforce.monan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.AutenticacaoDTO;
import br.com.bforce.monan.service.IAutenticacaoService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {
	
	@Autowired
	private IAutenticacaoService autenticacaoService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AutenticacaoDTO autenticacaoDTO) {
		return ResponseEntity.ok( autenticacaoService.login(autenticacaoDTO) );
	}
}
