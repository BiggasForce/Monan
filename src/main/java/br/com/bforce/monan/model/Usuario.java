package br.com.bforce.monan.model;

import java.time.LocalDateTime;

import br.com.bforce.monan.enums.TipoUsuarioEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=500, nullable=false)
	private String nome;
	
	@Column(length=500, nullable=false)
	private String email;
	
	@Column(length=128, nullable=false)
	private String senha;
	
	@Transient
	private TipoUsuarioEnum tipoUsuario;
	
	@Column(length=2, nullable=false)
	private String tipoUsuarioCod;
	
	@Column
	private LocalDateTime dataCriacao;
	
	@Column
	private LocalDateTime dataNascimento;
	
	public Usuario()
	{
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		if (tipoUsuario == null)
		{
			tipoUsuario = tipoUsuarioCod != null ? TipoUsuarioEnum.recuperarPorCodigo(tipoUsuarioCod) : null;
		}
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
		this.tipoUsuarioCod = tipoUsuario != null ?  tipoUsuario.getCodigo() : null;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}