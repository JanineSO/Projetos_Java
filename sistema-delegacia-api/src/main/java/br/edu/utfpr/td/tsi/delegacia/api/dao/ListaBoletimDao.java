package br.edu.utfpr.td.tsi.delegacia.api.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculoRep;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Emplacamento;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Endereco;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.BoletimNaoEncontradoException;
import jakarta.annotation.PostConstruct;

@Component
public class ListaBoletimDao implements BoletimOcorrenciaDao{
	
	ArrayList<BoletimFurtoVeiculo> boletins = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		inserirCsv();
	}


	@Override
	public void cadastrar(BoletimFurtoVeiculo boletim) {
		boletins.add(boletim);		
	}

	@Override
	public void alterar(BoletimFurtoVeiculo boletim) {
		int pos = -0;
			for (BoletimFurtoVeiculo bo : boletins) {
				if (bo.getIdentificador().equals(boletim.getIdentificador())) {
					pos = boletins.indexOf(bo);
					boletins.set(pos, boletim);
				}
			}
			if(pos < 0) {
				throw new BoletimNaoEncontradoException("Boletim não encontrado");
			}
		
	}

	@Override
	public void remover(String id) {
		int pos = -0;
		int posicao = 0;
		if (id != null) {
			for (BoletimFurtoVeiculo bo : boletins) {
				if (bo.getIdentificador().equalsIgnoreCase(id)) {
					posicao = boletins.indexOf(bo);
					boletins.remove(posicao);
					pos++;					
				}
			}
		}
		if(pos < 0) {
			throw new BoletimNaoEncontradoException("Boletim não encontrado");
		}
	}

	@Override
	public BoletimFurtoVeiculo consultar(String identificador) {
		BoletimFurtoVeiculo boletimFiltrado = new BoletimFurtoVeiculo();
		try {
			for (BoletimFurtoVeiculo boletim : boletins) {
				if (boletim.getIdentificador().equalsIgnoreCase(identificador) ) {
					boletimFiltrado = boletim;
				}
			}
	    
			return boletimFiltrado;
		}catch(Exception e) {
			throw new BoletimNaoEncontradoException("Boletim não encontrado");
		}
	}
	
	@Override
	public  List<BoletimFurtoVeiculo> consultarBoletins(String identificador, String cidade, String periodoOcorrencia) {
		List<BoletimFurtoVeiculo> boletimFiltrado = new ArrayList<>();
		try {
			for (BoletimFurtoVeiculo boletim : boletins) {
				if ((identificador == null || identificador.isEmpty() || boletim.getIdentificador().equalsIgnoreCase(identificador))
		                && (cidade == null || cidade.isEmpty() || boletim.getLocalOcorrencia().getCidade().equalsIgnoreCase(cidade))
		                && (periodoOcorrencia == null || periodoOcorrencia.isEmpty() || boletim.getPeriodoOcorrencia().equalsIgnoreCase(periodoOcorrencia))) {
					boletimFiltrado.add(boletim);
				}
			}
	    
			return boletimFiltrado;
		}catch(Exception e) {
			throw new BoletimNaoEncontradoException("Boletim não encontrado");
		}
	}

	@Override
	public List<BoletimFurtoVeiculo> listarTodos() {
		return boletins;

	}

	
	public void inserirCsv() {
	    try {
	    	FileReader dados = new FileReader("furtos.csv");
	        @SuppressWarnings("deprecation")
			CSVFormat configuracao = CSVFormat.Builder.create().setDelimiter('\t').setSkipHeaderRecord(true).build().withFirstRecordAsHeader();
	        try (CSVParser csv = new CSVParser(dados, configuracao)) {
				for (CSVRecord record : csv) {
				    BoletimFurtoVeiculoRep boletimRep = new BoletimFurtoVeiculoRep(record.get(2), record.get(5), record.get(7), record.get(13), record.get(14), record.get(15), record.get(16), record.get(17),record.get(49), record.get(47), record.get(48), record.get(51),record.get(44), record.get(45), record.get(46));
				    BoletimFurtoVeiculo boletim = boletimRep.converterParaDominio();
				    boletins.add(boletim);
				}
			}

	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Erro ao ler o arquivo csv!");
	    }
	}


	@Override
	public List<Veiculo> consultarVeiculos(String placa, String cor, String tipoVeiculo) {
		List<Veiculo> boletimFiltrado = new ArrayList<>();
		try {
			for (BoletimFurtoVeiculo boletim : boletins) {
				if ((placa == null || placa.isEmpty() || boletim.getVeiculoFurtado().getEmplacamento().getPlaca().equalsIgnoreCase(placa))
		                && (cor == null || cor.isEmpty() || boletim.getVeiculoFurtado().getCor().equalsIgnoreCase(cor))
		                && (tipoVeiculo == null || tipoVeiculo.isEmpty() || boletim.getVeiculoFurtado().getTipoVeiculo().equalsIgnoreCase(tipoVeiculo))) {
					boletimFiltrado.add(boletim.getVeiculoFurtado());
				}
			}
	    
			return boletimFiltrado;
		}catch(Exception e) {
			throw new BoletimNaoEncontradoException("Boletim não encontrado");
		}
	}

	
}
