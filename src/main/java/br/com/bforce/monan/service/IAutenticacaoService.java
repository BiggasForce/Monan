package br.com.bforce.monan.service;

import br.com.bforce.monan.model.AcessoDTO;
import br.com.bforce.monan.model.AutenticacaoDTO;
import br.com.bforce.monan.model.RegisterDTO;

public interface IAutenticacaoService {
	
	public AcessoDTO login(AutenticacaoDTO autenticacaoDTO);
	public String register(RegisterDTO regDTO);
}
