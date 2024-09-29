package br.com.bforce.monan.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "atividade")
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "seq_atividade" ) 
	@SequenceGenerator(name="seq_atividade", sequenceName = "seq_atividade", allocationSize = 1)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column (nullable = false)
	private LocalDateTime dataEntrega;
	
	@Column (nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	@JsonIgnore
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="nota_id")
	private Nota nota;

	public Atividade(){
	}
	
	public Atividade(AtividadeDTO atividadeDTO) {
		
		this.id = atividadeDTO.getId();
		this.nome = atividadeDTO.getNome();
		this.dataEntrega = atividadeDTO.getDataEntrega();
		this.descricao = atividadeDTO.getDescricao();
		this.disciplina = atividadeDTO.getIdDisciplina();
		this.nota = atividadeDTO.getIdNota();
		
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
