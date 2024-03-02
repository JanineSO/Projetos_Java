package br.edu.utfpr.td.tsi.delegacia.api.dominio;

public class BoletimFurtoVeiculo {
	private String identificador;
	private String dataOcorrencia;
	private String periodoOcorrencia;
	private Parte partes;
	private Endereco localOcorrencia;
	private Veiculo veiculoFurtado;
	
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getDataOcorrencia() {
		return dataOcorrencia;
	}
	public void setDataOcorrencia(String dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}
	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}
	public Parte getPartes() {
		return partes;
	}
	public void setPartes(Parte partes) {
		this.partes = partes;
	}
	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}
	public void setLocalOcorrencia(Endereco localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}
	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}
	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}
	
	
}
