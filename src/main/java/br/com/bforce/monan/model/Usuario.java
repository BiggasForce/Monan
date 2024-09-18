package br.com.bforce.monan.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bforce.monan.enums.TipoUsuarioEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table (name = "usuario")
public class Usuario implements UserDetails{
	private static final long serialVersionUID = 8854849685621427159L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario",  allocationSize=1)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", length=500, nullable=false)
	private String nome;
	
	@Column(name="email", length=500, nullable=false)
	private String email;
	
	@Column(name="senha", length=128, nullable=false)
	private String senha;
	
	@Transient
	private TipoUsuarioEnum tipoUsuario;
	
	@Column(name="tipo", length=2, nullable=false)
	private String tipoUsuarioCod;
	
	@Column(name="data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name="data_nascimento")
	private LocalDateTime dataNascimento;
	
	public Usuario() {
	}
	
	public Usuario(UsuarioDTO usuarioDTO) {
		this.nome = usuarioDTO.getNome();
		this.email = usuarioDTO.getEmail();
		this.senha = usuarioDTO.getSenha();
		this.tipoUsuarioCod = usuarioDTO.getTipoUsuario();
		this.dataCriacao = LocalDateTime.now();
		this.dataNascimento = usuarioDTO.getDataNascimento();
	}
	
	public Usuario(RegisterDTO regDTO) {
		this.nome = regDTO.getNome();
		this.email = regDTO.getEmail();
		this.senha = regDTO.getSenha();
		
		//
		// por padrão cria todos os usuários registrados pelo sistema como ALUNO.
		this.tipoUsuarioCod = TipoUsuarioEnum.ALUNO.getCodigo();
		this.dataCriacao = LocalDateTime.now();
		this.dataNascimento = LocalDateTime.ofInstant(regDTO.getDataNascimento().toInstant(), ZoneId.systemDefault());
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
		this.email = email.trim();
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.getTipoUsuario().ehGestor()){
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}
		else if (this.getTipoUsuario().ehProfessor()){
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
		else if (this.getTipoUsuario().ehAluno()){
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}