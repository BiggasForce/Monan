package br.com.bforce.monan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.dao.DisciplinaDao;
import br.com.bforce.monan.model.Disciplina;
import br.com.bforce.monan.model.Usuario;

@Component
public class DisciplinaService extends ServiceBase<Disciplina, Long> implements IDisciplinaService{

	@Autowired
	private DisciplinaDao dao;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public DisciplinaDao getDao() {
		return dao;
	}
	
	@Override
	public Disciplina criarNovaDisciplina(Disciplina disciplina) {
		if (disciplina.getNome() == null || disciplina.getNome().length() == 0) {
			return null;
		}
		return getDao().save(disciplina);
	}

	@Override
	public Disciplina salvar(Disciplina disciplina) {
		return getDao().save(disciplina);
	}

	@Override
	public List<Disciplina> listarDisciplinas(String token) throws Exception{
		
		Long idUsuario = extrairId(token);
		Usuario usuario = usuarioService.buscarPorId(idUsuario);
		
		if (usuario != null )
		{
			return usuario.getDisciplinas();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Disciplina> pesquisar(String termoPesquisa) {
		return getDao().findAllByNomeContaining(termoPesquisa);
	}
}
