package br.com.bforce.monan.enums;

import java.util.Arrays;

public enum TipoUsuarioEnum {

	ALUNO		("A", "Aluno"),
	
	PROFESSOR	("P", "Professor"),
	
	GESTOR		("G", "Gestor");
	
	private String codigo;
	private String descricao;
	
	TipoUsuarioEnum(String codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoUsuarioEnum recuperarPorCodigo(String codigo){
		return Arrays.stream(values())
    			.filter(tipo -> tipo.codigo.compareTo(codigo) == 0)
    			.findFirst()
    			.orElse(null);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean ehAluno()
	{
		return this.equals(TipoUsuarioEnum.ALUNO);
	}
	
	public boolean ehProfessor()
	{
		return this.equals(TipoUsuarioEnum.PROFESSOR);
	}
	
	public boolean ehGestor()
	{
		return this.equals(TipoUsuarioEnum.GESTOR);
	}
}