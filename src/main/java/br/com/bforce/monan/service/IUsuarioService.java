package br.com.bforce.monan.service;

import java.util.List;

import br.com.bforce.monan.model.Usuario;

public interface IUsuarioService {
	public Usuario criarNovoUsuario(Usuario usuario);
	public Usuario salvar(Usuario usuario);
	public List<Usuario> listarUsuarios();
	public List<Usuario> pesquisar(String termoPesquisa);
	public Usuario login(String email, String senha);
	public boolean emailJaExistente(String email);
}
