package br.com.bforce.monan.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.bforce.monan.model.Atividade;
import java.util.List;

public interface AtividadeDao extends CrudRepository<Atividade, Long>{
	
	public List<Atividade> findAllByNameContaining(String key);

	
}
