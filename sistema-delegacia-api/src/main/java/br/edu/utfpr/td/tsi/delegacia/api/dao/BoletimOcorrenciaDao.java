package br.edu.utfpr.td.tsi.delegacia.api.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Veiculo;

@Component
public interface BoletimOcorrenciaDao {
	void cadastrar(BoletimFurtoVeiculo boletim);
	void alterar(BoletimFurtoVeiculo boletim);
	void remover(String idBoletim);
	BoletimFurtoVeiculo consultar(String identificador);
	List<BoletimFurtoVeiculo> consultarBoletins(String identificador, String cidade, String periodoOcorrencia);
	List<BoletimFurtoVeiculo> listarTodos();
	List<Veiculo> consultarVeiculos(String placa, String cor, String tipoVeiculo);
}
