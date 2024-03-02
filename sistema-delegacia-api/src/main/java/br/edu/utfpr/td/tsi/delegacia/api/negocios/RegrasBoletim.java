package br.edu.utfpr.td.tsi.delegacia.api.negocios;

import java.io.IOException;
import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Veiculo;

public interface RegrasBoletim {
	public void cadastrar(BoletimFurtoVeiculo boletim) throws IOException;
	public void alterar(BoletimFurtoVeiculo boletim) throws IOException;
	public void remover(String boletim) throws IOException;
	BoletimFurtoVeiculo consultar(String idBoletim) throws IOException;
	List <BoletimFurtoVeiculo> consultarBoletins(String identificador, String cidade, String periodoOcorrencia) throws IOException;
	List<BoletimFurtoVeiculo> listarTodos() throws IOException;
	List <Veiculo> consultarVeiculos(String placa, String cor, String tipoVeiculo) throws IOException;
}
