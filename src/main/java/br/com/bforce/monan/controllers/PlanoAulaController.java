package br.com.bforce.monan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.PlanoAula;
import br.com.bforce.monan.service.IPlanoAulaService;

@RestController
@RequestMapping(value="/monan/planos-aula")
@CrossOrigin("*")
public class PlanoAulaController {
	
	@Autowired
	private IPlanoAulaService service;
	
	@GetMapping("/{token}")
	public ResponseEntity <List<PlanoAula>> listarPlanosAula (@PathVariable String token){
		try
		{
			return ResponseEntity.ok(service.buscarTodos(token));
		}
		catch (Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
		
		
	}
	
}
