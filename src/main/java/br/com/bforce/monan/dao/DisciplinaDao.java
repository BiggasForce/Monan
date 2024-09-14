package br.com.bforce.monan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.bforce.monan.model.Disciplina;

public interface DisciplinaDao extends CrudRepository<Disciplina, Long>{
	
	public List<Disciplina> findAllByNomeContaining(String key);
}
