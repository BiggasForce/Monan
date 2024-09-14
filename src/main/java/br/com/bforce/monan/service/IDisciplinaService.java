package br.com.bforce.monan.service;

import java.util.List;

import br.com.bforce.monan.model.Disciplina;

public interface IDisciplinaService {
	
	public Disciplina criarNovaDisciplina(Disciplina Disciplina);
	public Disciplina salvar(Disciplina Disciplina);
	public List<Disciplina> listarDisciplinas();
	public List<Disciplina> pesquisar(String termoPesquisa);
}
