package br.com.bforce.monan.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.com.bforce.monan.model.Nota;

public interface NotaDao extends CrudRepository<Nota, Long>{
	
	List<Nota> findByValorLessThan(double valor);
	List<Nota> findByValorGreaterThan(double valor);

}
