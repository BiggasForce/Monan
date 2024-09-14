package br.com.bforce.monan.model;

public class AcessoDTO {
	
	private String token;
	
	public AcessoDTO() {
	}
	
	public AcessoDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
