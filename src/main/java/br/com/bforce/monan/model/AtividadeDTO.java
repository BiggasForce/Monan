package br.com.bforce.monan.model;

import java.time.LocalDateTime;

public class AtividadeDTO {
	
	private Long id;
	private String nome;
	private LocalDateTime dataEntrega;
	private String descricao;
	private Disciplina idDisciplina;
	private Nota idNota;
	
	public AtividadeDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Disciplina getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Disciplina idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public Nota getIdNota() {
		return idNota;
	}
	public void setIdNota(Nota idNota) {
		this.idNota = idNota;
	}
	
	
}
