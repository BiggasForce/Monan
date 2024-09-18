package br.com.bforce.monan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bforce.monan.service.IUsuarioService;

@RestController
@RequestMapping(value="/monan/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosController {
	
	@Autowired
	private IUsuarioService service;
	
}
