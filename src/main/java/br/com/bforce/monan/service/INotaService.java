package br.com.bforce.monan.service;

import java.util.List;

import br.com.bforce.monan.model.Nota;

public interface INotaService {
	
	public Nota lancarNota(Nota Nota);
	public Nota editarNota(Nota Nota);
	public List<Nota> listarNotas();
	public List<Nota> listarAbaixoDaMedia();
	public List<Nota> listarMaiorQue();
}
