package br.com.bforce.monan.service;

import br.com.bforce.monan.model.Atividade;
import java.util.List;

public interface IAtividadeService {

		public Atividade criarAtividade(Atividade atividade);
		public Atividade editarAtividade(Atividade atividade);
		public List<Atividade> listarAtividades(String token);
		public List<Atividade> pesquisarAtividade(String termoPesquisa);
		
}
