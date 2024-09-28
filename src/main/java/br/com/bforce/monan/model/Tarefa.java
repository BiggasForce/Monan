package br.com.bforce.monan.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 785481915621427159L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tarefa")
	@SequenceGenerator(name = "seq_tarefa", sequenceName = "seq_tarefa",  allocationSize=1)
	private Long id;
	
	@Column(length=500, nullable=false)
	private String nome;
	
	@Column(length=5000)
	private String descricao;
	
	@OneToMany(mappedBy="tarefa")
	private List<Nota> notas;
	
	public Tarefa() {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
