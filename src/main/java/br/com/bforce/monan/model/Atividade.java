package br.com.bforce.monan.model;

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
		private Disciplina idDisciplina;
		
		@ManyToOne
		@JoinColumn(name="nota_id")
		private Nota idNota;

		
		public Atividade(){
			
		}
		
		public Atividade(AtividadeDTO atividadeDTO) {
			
			this.id = atividadeDTO.getId();
			this.nome = atividadeDTO.getNome();
			this.dataEntrega = atividadeDTO.getDataEntrega();
			this.descricao = atividadeDTO.getDescricao();
			this.idDisciplina = atividadeDTO.getIdDisciplina();
			this.idNota = atividadeDTO.getIdNota();
			
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
