package br.com.bforce.monan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.dao.AtividadeDao;
import br.com.bforce.monan.model.Atividade;
import br.com.bforce.monan.model.Disciplina;
import br.com.bforce.monan.model.Usuario;

@Component
public class AtividadeService extends ServiceBase<Atividade, Long> implements IAtividadeService{

	@Autowired
	private AtividadeDao dao;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	public List<Atividade> listarAtividades(String token) {
		
		Long idUsuario = extrairId(token);
		Usuario usuario = usuarioService.buscarPorId(idUsuario);
		List<Atividade> atividades = new ArrayList<>();
		
		if (usuario != null )
		{
			for (Disciplina disciplina : usuario.getDisciplinas())
			{
				atividades.addAll(disciplina.getAtividades());
			}
			usuario.getDisciplinas();
		}
		
		
		return atividades;
	}

	@Override
	public List<Atividade> pesquisarAtividade(String termoPesquisa) {
		return getDao().findAllByNomeContaining(termoPesquisa);
	}

}
