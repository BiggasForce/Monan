package br.com.bforce.monan.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table (name="planoAula")
public class PlanoAula implements Serializable{	
	private static final long serialVersionUID = -1372542254109385148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_planoAula" )
	@SequenceGenerator(name = "seq_planoAula", sequenceName= "seq_planoAula", allocationSize =1 ) 
	private Long id;
	
	@Column(nullable= false)
	private  String titulo;
	
	@Column(length = 5000)
	private  String descricao;
	
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	
	@ManyToOne 
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	public PlanoAula() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
