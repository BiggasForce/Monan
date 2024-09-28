package br.com.bforce.monan.service;

import java.util.List;

import br.com.bforce.monan.dao.AtividadeDao;
import br.com.bforce.monan.model.Atividade;

public class AtividadeService extends ServiceBase<Atividade, Long> implements IAtividadeService{

	private AtividadeDao dao;
	
	public AtividadeDao getDao() {
		return dao;
	}
	@Override
	public Atividade criarAtividade(Atividade atividade) {
		return getDao().save(atividade);
	}

	@Override
	public Atividade editarAtividade(Atividade atividade) {
		return getDao().save(atividade);
	}

	@Override
	public List<Atividade> listarAtividades() {
		return (List<Atividade>)getDao().findAll();
	}

	@Override
	public List<Atividade> pesquisarAtividade(String termoPesquisa) {
		return getDao().findAllByNameContaining(termoPesquisa);
	}

}
