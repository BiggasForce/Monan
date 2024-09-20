package br.com.bforce.monan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.model.Nota;
import br.com.bforce.monan.model.NotaDTO;
import br.com.bforce.monan.model.Usuario;
import br.com.bforce.monan.model.UsuarioDTO;
import br.com.bforce.monan.service.INotaService;

@RestController
@RequestMapping(value="/notas")
@CrossOrigin
public class NotaController {
		
		@Autowired
		private INotaService service;
		
		@PostMapping
		public ResponseEntity<Nota> lancarNota(@RequestBody NotaDTO novaNotaDTO) {
			Nota Nota = service.lancarNota(new Nota(novaNotaDTO));
			if (Nota != null) {
				return ResponseEntity.status(201).body(Nota);
			}
			return ResponseEntity.badRequest().build();
		}
}
