package br.com.bforce.monan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.dao.UsuarioDao;
import br.com.bforce.monan.model.Usuario;

@Component
public class UsuarioService extends ServiceBase<Usuario, Long> implements IUsuarioService, UserDetailsService {

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	public UsuarioDao getDao() {
		return dao;
	}
	
	@Override
	public Usuario criarNovoUsuario(Usuario usuario) {
		usuario.setSenha(passEncoder.encode(usuario.getSenha()));
		return getDao().save(usuario);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		usuario.setSenha(passEncoder.encode(usuario.getSenha()));
		return getDao().save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return (List<Usuario>) getDao().findAll();
	}

	@Override
	public List<Usuario> pesquisar(String termoPesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario login(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * USADO PARA FAZER LOGIN (nao mexer)
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// considera o e-mail como username  de login
		Usuario usuario = dao.findByEmail(email.trim()).orElse(null);
		return usuario;
	}
	
	public boolean emailJaExistente(String email) {
		return loadUserByUsername(email) != null;
	}
	
	public Usuario buscarPorId(Long id)
	{
		return getDao().findById(id).orElse(null);
	}
	
}
