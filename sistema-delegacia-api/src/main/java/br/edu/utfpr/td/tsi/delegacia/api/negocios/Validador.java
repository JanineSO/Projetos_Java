package br.edu.utfpr.td.tsi.delegacia.api.negocios;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;

@Component
public interface Validador {
	public boolean formatoEmail(String email);
	public boolean formatoData(String data);
	public boolean dadosObrigatorios(BoletimFurtoVeiculo boletim);
}
