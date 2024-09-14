package br.com.bforce.monan.service;

import br.com.bforce.monan.model.AcessoDTO;
import br.com.bforce.monan.model.AutenticacaoDTO;

public interface IAutenticacaoService {
	
	public AcessoDTO login(AutenticacaoDTO autenticacaoDTO);
}
