package br.com.bforce.monan.model;

import java.time.LocalDate;

public class NotaDTO {
	
	private long id;
	private double valor;
	private LocalDate dataLancamento;
	private Usuario idAluno;
	private Disciplina idDisciplina;
	
	public NotaDTO() {
		
	}	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public Usuario getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Usuario idAluno) {
		this.idAluno = idAluno;
	}
	public Disciplina getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Disciplina idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	
}
