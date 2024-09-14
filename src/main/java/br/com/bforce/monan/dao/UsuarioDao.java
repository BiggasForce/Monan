package br.com.bforce.monan.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.bforce.monan.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);
}
