package br.com.bforce.monan.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.bforce.monan.model.Usuario;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTUtils {
	
	@Value("${monan.jwtUtils.jwtSecret}")
	private String jwtSecret;
	
	@Value("${monan.jwtUtils.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateToken(Usuario userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(getSigninKey(), SignatureAlgorithm.HS256).compact();
	}
	
	public Key getSigninKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
			return true;
		}
		catch (MalformedJwtException e) {
			System.err.println("Token invalido: "+e.getMessage());
		}
		catch (ExpiredJwtException e){
			System.err.println("Token expirado: "+e.getMessage());
		}
		catch (UnsupportedJwtException e){
			System.err.println("Token nao suportado: "+e.getMessage());
		}
		catch (IllegalArgumentException e){
			System.err.println("Token argumento invalido: "+e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Retorna o login (e-mail) do token
	 * @param token
	 * @return
	 */
	public String getLoginToken(String token) {
		return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody().getSubject();
	}
}
