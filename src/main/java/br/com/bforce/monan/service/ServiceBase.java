package br.com.bforce.monan.service;

/**
 * 
 * Classe deve ser utilizada para implementar todos os métodos e funções que sejam úteis
 * e comuns a todos os 'Services' do sistema
 * - Criar os métodos visíveis para as classes herdeiras como 'Protected'
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class ServiceBase<T, ID> {
	
	protected String formatarString(String texto){
		return texto.trim();
	}
	
	protected Long extrairId(String token)
	{
		token = token.replaceAll("\"", "");
		String id = "";
		
		switch (token.length()) {
			case 11:
				id = token.substring(1, 2);
				break;
			case 12:
				id = token.substring(1, 3);
				break;
			case 13:
				id = token.substring(1, 4);
				break;
			case 14:
				id = token.substring(1, 5);
		}
		
		return Long.parseLong(id);
	}
}
