package br.com.bforce.monan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.Atividade;
import br.com.bforce.monan.service.IAtividadeService;

@RestController
@RequestMapping(value="/atividade")
@CrossOrigin("*")
public class AtividadeController {
	
	@Autowired
	private IAtividadeService service;
	
	@PostMapping
	public ResponseEntity<Atividade> criarAtividade (@RequestBody Atividade novaAtividade){
		Atividade atividade = service.criarAtividade(novaAtividade);
		if(atividade!=null)
			return ResponseEntity.status(201).body(atividade);
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping 
	public ResponseEntity <List<Atividade>> listarAtividades (){
		return ResponseEntity.ok(service.listarAtividades());
		
	}
	
}
