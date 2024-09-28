package br.com.bforce.monan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.dao.NotaDao;
import br.com.bforce.monan.model.Disciplina;
import br.com.bforce.monan.model.Nota;

@Component
public class NotaService extends ServiceBase<Nota, Long> implements INotaService {
	
	@Autowired
	private NotaDao dao;
	
	public NotaDao getDao() {
		return dao;
	}
	
	
	@Override
	public Nota lancarNota(Nota Nota) {
		return getDao().save(Nota);
	}

	@Override
	public Nota editarNota(Nota Nota) {
		return getDao().save(Nota);
	}

	@Override
	public List<Nota> listarNotas() {
		return (List<Nota>) getDao().findAll();
	}

	@Override
	public List<Nota> listarAbaixoDaMedia() {
		return (List<Nota>) getDao().findByValorLessThan(60);
	}


	@Override
	public List<Nota> listarMaiorQue() {
		return (List<Nota>) getDao().findByValorGreaterThan(90);
	}




}
