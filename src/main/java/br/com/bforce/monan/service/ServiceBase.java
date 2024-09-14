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
}
