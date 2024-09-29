package br.com.bforce.monan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.dao.PlanoAulaDao;
import br.com.bforce.monan.model.PlanoAula;

@Component
public class PlanoAulaService extends ServiceBase<PlanoAula, Long> implements IPlanoAulaService {
	
	@Autowired
	private PlanoAulaDao dao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public PlanoAulaDao getDao() {
		return dao;
	}
	
	public List<PlanoAula> buscarTodos(String token) {
		if (usuarioService.buscarPorId(extrairId(token)) == null)
		{
			return new ArrayList<>();
		}
		return (List<PlanoAula>) getDao().findAll();
	}

}
