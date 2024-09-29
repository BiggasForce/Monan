package br.com.bforce.monan.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "disciplina")
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 785484915621427159L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_disciplina")
	@SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina",  allocationSize=1)
	private Long id;
	
	@Column(length=500, nullable=false)
	private String nome;
	
	@Column(length=5000)
	private String descricao;
	
	@ManyToMany(mappedBy = "disciplinas")
	@JsonIgnore
    private List<Usuario> alunos;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Atividade> atividades;
	
	public Disciplina() {
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

	public List<Usuario> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Usuario> alunos) {
		this.alunos = alunos;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
}
