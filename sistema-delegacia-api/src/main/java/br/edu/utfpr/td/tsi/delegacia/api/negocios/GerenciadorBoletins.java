package br.edu.utfpr.td.tsi.delegacia.api.negocios;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.dao.BoletimOcorrenciaDao;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Veiculo;
import jakarta.transaction.Transactional;

@Component
public class GerenciadorBoletins implements RegrasBoletim {
	
	@Autowired 
	Validador validador;
	
	@Autowired
	private BoletimOcorrenciaDao boletimDao;

	@Override
	@Transactional
	public void cadastrar(BoletimFurtoVeiculo boletim) throws IOException {
		if(!validador.dadosObrigatorios(boletim)) {
			throw new  DadosObrigatorioException("É necessário informar todos os dados!");
		}else if(!validador.formatoEmail(boletim.getPartes().getEmail())){
			throw new  FormatoEmailException("O formato do email informado está incorreto!");
		}else if(!validador.formatoData(boletim.getDataOcorrencia())){
			throw new  FormatoDataException("O formato da data informada está incorreto!");
		}else {
			boletimDao.cadastrar(boletim);
		}
		
	}

	@Override
	@Transactional
	public void alterar(BoletimFurtoVeiculo boletim) throws IOException {
		boletimDao.alterar(boletim);
	}

	@Override
	@Transactional
	public void remover(String boletim) {
		boletimDao.remover(boletim);
	}

	@Override
	public BoletimFurtoVeiculo consultar(String idBoletim) {
		BoletimFurtoVeiculo boletim = boletimDao.consultar(idBoletim);
		return boletim;
	}

	@Override
	public List<BoletimFurtoVeiculo> listarTodos(){
		return boletimDao.listarTodos();
	}

	@Override
	public List<BoletimFurtoVeiculo> consultarBoletins(String identificador, String cidade, String periodoOcorrencia){
		return boletimDao.consultarBoletins(identificador, cidade, periodoOcorrencia);
	}

	@Override
	public List<Veiculo> consultarVeiculos(String placa, String cor, String tipoVeiculo){
		return boletimDao.consultarVeiculos(placa, cor, tipoVeiculo);
	}

}
