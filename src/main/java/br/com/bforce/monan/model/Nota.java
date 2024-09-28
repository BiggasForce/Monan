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
@Table (name="nota")
public class Nota implements Serializable{	
	private static final long serialVersionUID = -2272542254109385148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota" )
	@SequenceGenerator(name = "seq_nota", sequenceName= "seq_nota", allocationSize =1 ) 
	private long id;
	
	@Column(nullable= false)
	private  Double valor;
	
	@Column(nullable = false)
	private LocalDateTime dataLancamento;

	@ManyToOne 
	@JoinColumn(name = "usuario_id")
	private Usuario aluno;
	
	@ManyToOne 
	@JoinColumn(name = "tarefa_id")
	private Tarefa tarefa;
	
	public Nota() {
		
	}
	
	public Nota(NotaDTO notaDTO) {
		this.id = notaDTO.getId();
		this.valor = notaDTO.getValor();
		this.dataLancamento = LocalDateTime.now();
		this.aluno = notaDTO.getAluno();
		this.tarefa = notaDTO.getTarefa();
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

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
}
