package br.com.bforce.monan.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.model.AcessoDTO;
import br.com.bforce.monan.model.AutenticacaoDTO;
import br.com.bforce.monan.model.RegisterDTO;
import br.com.bforce.monan.model.Usuario;
import br.com.bforce.monan.security.jwt.JWTUtils;

@Component
public class AutenticacaoService implements IAutenticacaoService{
	
	//
	// login podre gambiarra 2200.87
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();
	
	@Autowired
	private AuthenticationManager authenticationMenager;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public AcessoDTO login(AutenticacaoDTO autenticacaoDTO) {
		try {
			
			// verificar se usuario existe
			if (usuarioService.loadUserByUsername(autenticacaoDTO.getLogin()) == null)
				throw new UsernameNotFoundException("Usuário não encontrado");
			
			UsernamePasswordAuthenticationToken userAuth =
					new UsernamePasswordAuthenticationToken(autenticacaoDTO.getLogin(), autenticacaoDTO.getSenha());
			
			Authentication authentication = authenticationMenager.authenticate(userAuth);
			
			Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
			
			//String token = jwtUtils.generateToken(usuarioLogado);
			String token = gerarTokenPeloId(usuarioLogado.getId());
			
			return new AcessoDTO(token);
		}
		catch (UsernameNotFoundException e) {
			// tratar caso o usuário não seja encontrado
	        return null;
	    }
		catch (BadCredentialsException e) {
			// TODO login ou senha inválidos
			return null;
		}
	}

	@Override
	public String register(RegisterDTO regDTO) {
		
		try {
			if (usuarioService.emailJaExistente(regDTO.getEmail())) {
				return "Já existe um usuário registrado com o e-mail informado!";
			}
			usuarioService.criarNovoUsuario(new Usuario(regDTO));
			
			return "Registrado com sucesso";
		}
		catch (Exception e) {
			// TODO falha ao registrar
			return "Erro ao registrar usuário";
		}
	}
	
	private String gerarTokenPeloId(Long id)
	{
		StringBuilder codigo = new StringBuilder();
		for (int i = 0; i <= 10; i++) {
			
			if (i == 1)
			{
				//
				// adiciona o id na 2 casa
				codigo.append(id.toString());
			}
			else
			{
	            int index = random.nextInt(CHARACTERS.length());
	            codigo.append(CHARACTERS.charAt(index));
			}
        }
		
		return codigo.toString();
	}
}
