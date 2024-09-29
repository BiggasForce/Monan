package br.com.bforce.monan.service;

import java.util.List;

import br.com.bforce.monan.model.PlanoAula;

public interface IPlanoAulaService {
	public List<PlanoAula> buscarTodos(String token);
}
