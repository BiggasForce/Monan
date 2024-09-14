package br.com.bforce.monan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.model.AcessoDTO;
import br.com.bforce.monan.model.AutenticacaoDTO;
import br.com.bforce.monan.model.Usuario;
import br.com.bforce.monan.security.jwt.JWTUtils;

@Component
public class AutenticacaoService implements IAutenticacaoService{
	
	@Autowired
	private AuthenticationManager authenticationMenager;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Override
	public AcessoDTO login(AutenticacaoDTO autenticacaoDTO) {
		try {
			UsernamePasswordAuthenticationToken userAuth =
					new UsernamePasswordAuthenticationToken(autenticacaoDTO.getLogin(), autenticacaoDTO.getSenha());
			
			Authentication authentication = authenticationMenager.authenticate(userAuth);
			
			Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
			
			String token = jwtUtils.generateToken(usuarioLogado);
			
			return new AcessoDTO(token);
		}
		catch (BadCredentialsException e) {
			// TODO login ou senha inválidos
		}
		
		return null;
	}
}
