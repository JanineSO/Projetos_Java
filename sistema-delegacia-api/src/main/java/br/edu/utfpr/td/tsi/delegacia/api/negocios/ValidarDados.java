package br.edu.utfpr.td.tsi.delegacia.api.negocios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;

@Component
public class ValidarDados implements Validador{

	@Override
	public boolean formatoEmail(String email) {
		Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		
		return matchFound;
	}

	@Override
	public boolean formatoData(String data) {
		Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
		Matcher m = p.matcher(data);
		boolean matchFound = m.matches();
		
		return matchFound;
	}

	@Override
	public boolean dadosObrigatorios(BoletimFurtoVeiculo boletim) {
		boolean variavelBooleana = false;
		
		if(boletim.getDataOcorrencia() == null || boletim.getDataOcorrencia().isEmpty()) {
			variavelBooleana = true;
		}
		
		if(boletim.getPeriodoOcorrencia() == null || boletim.getPeriodoOcorrencia().isEmpty()) {
			variavelBooleana = true;
		}
		
		if(boletim.getPartes() != null) {
			if(boletim.getPartes().getEmail() == null || boletim.getPartes().getEmail().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getPartes().getNome() == null || boletim.getPartes().getNome().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getPartes().getTelefone() == null || boletim.getPartes().getTelefone().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getPartes().getTipoEnvolvimento() == null || boletim.getPartes().getTipoEnvolvimento().isEmpty()) {
				variavelBooleana = true;
			}
		}
			
		if(boletim.getLocalOcorrencia() != null) {
			if(boletim.getLocalOcorrencia().getBairro() == null || boletim.getLocalOcorrencia().getBairro().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getLocalOcorrencia().getCidade() == null || boletim.getLocalOcorrencia().getCidade().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getLocalOcorrencia().getLogradouro() == null || boletim.getLocalOcorrencia().getLogradouro().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getLocalOcorrencia().getNumero() == 0 || boletim.getLocalOcorrencia().getNumero() < 0) {
				variavelBooleana = true;
			}else if(boletim.getLocalOcorrencia().getEstado() == null || boletim.getLocalOcorrencia().getEstado().isEmpty()) {
				variavelBooleana = true;
			}
		}
		
		if(boletim.getVeiculoFurtado() != null) {
			if(boletim.getVeiculoFurtado().getAnoFabricacao() == null || boletim.getVeiculoFurtado().getAnoFabricacao().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getVeiculoFurtado().getCor() == null || boletim.getVeiculoFurtado().getCor().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getVeiculoFurtado().getMarca() == null || boletim.getVeiculoFurtado().getMarca().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getVeiculoFurtado().getTipoVeiculo() == null || boletim.getVeiculoFurtado().getTipoVeiculo().isEmpty()) {
				variavelBooleana = true;
			}
			
			if(boletim.getVeiculoFurtado().getEmplacamento().getCidade() == null || boletim.getVeiculoFurtado().getEmplacamento().getCidade().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getVeiculoFurtado().getEmplacamento().getEstado() == null || boletim.getVeiculoFurtado().getEmplacamento().getEstado().isEmpty()) {
				variavelBooleana = true;
			}else if(boletim.getVeiculoFurtado().getEmplacamento().getPlaca() == null || boletim.getVeiculoFurtado().getEmplacamento().getPlaca().isEmpty()) {
				variavelBooleana = true;
			}
		}
		
		
		return true;
	}

}
