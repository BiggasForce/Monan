package br.com.bforce.monan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.Disciplina;
import br.com.bforce.monan.service.IDisciplinaService;

@RestController
@RequestMapping(value="/monan/disciplinas")
@CrossOrigin("*")
public class DisciplinaController {

	@Autowired
	private IDisciplinaService service;
	
	@PostMapping
	public ResponseEntity<Disciplina> cadastrarNovaDisciplina(@RequestBody Disciplina novaDisciplina) {
		Disciplina disciplina = service.criarNovaDisciplina(novaDisciplina);
		if (disciplina != null) {
			return ResponseEntity.status(201).body(disciplina);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{token}")
	public ResponseEntity<List<Disciplina>> buscarDisciplinas(@PathVariable String token) {
		try
		{
			List<Disciplina> disciplinas = service.listarDisciplinas(token);
			
			return ResponseEntity.ok(disciplinas);
		}
		catch (Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
}
