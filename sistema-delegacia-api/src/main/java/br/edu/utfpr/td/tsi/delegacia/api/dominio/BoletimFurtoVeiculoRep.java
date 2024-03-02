package br.edu.utfpr.td.tsi.delegacia.api.dominio;

public class BoletimFurtoVeiculoRep {
	private String identificador;
	private String dataOcorrencia;
	private String periodoOcorrencia;
	private String nomeParte;
	private String emailParte;
	private String telefoneParte;
	private String tipoEnvolvimentoParte;
	private String logradouroEndereco;
	private String numeroEndereco;
	private String bairroEndereco;
	private String cidadeEndereco;
	private String estado;
	private String anoFabricacaoVeiculo;
	private String corVeiculo;
	private String marcaVeiculo;
	private String tipoVeiculoVeiculo;
	private String placaEmplacamento;
	private String estadoEmplacamento;
	private String cidadeEmplacamento;
	
	public BoletimFurtoVeiculoRep(BoletimFurtoVeiculo boletim) {
		this.identificador = boletim.getIdentificador();
		this.dataOcorrencia = boletim.getDataOcorrencia();
		this.periodoOcorrencia = boletim.getPeriodoOcorrencia();
		this.nomeParte = boletim.getPartes().getNome();
		this.emailParte = boletim.getPartes().getEmail();
		this.telefoneParte = boletim.getPartes().getTelefone();
		this.tipoEnvolvimentoParte = boletim.getPartes().getTipoEnvolvimento();
		this.logradouroEndereco = boletim.getLocalOcorrencia().getLogradouro();
		this.numeroEndereco = Integer.toString(boletim.getLocalOcorrencia().getNumero());
		this.bairroEndereco = boletim.getLocalOcorrencia().getBairro();
		this.cidadeEndereco = boletim.getLocalOcorrencia().getCidade();
		this.estado = boletim.getLocalOcorrencia().getEstado();
		this.anoFabricacaoVeiculo = boletim.getVeiculoFurtado().getAnoFabricacao();
		this.corVeiculo = boletim.getVeiculoFurtado().getCor();
		this.marcaVeiculo = boletim.getVeiculoFurtado().getMarca();
		this.tipoVeiculoVeiculo = boletim.getVeiculoFurtado().getTipoVeiculo();
		this.placaEmplacamento = boletim.getVeiculoFurtado().getEmplacamento().getPlaca();
		this.estadoEmplacamento = boletim.getVeiculoFurtado().getEmplacamento().getEstado();
		this.cidadeEmplacamento = boletim.getVeiculoFurtado().getEmplacamento().getCidade();
	}
	
	public BoletimFurtoVeiculoRep(String identificador, String data, String periodoOcorrencia,
		
			String logradouro, String numero, String bairro, String cidade, String estado, String ano, String cor, String marca, String tipoVeiculo,
			String placa, String estadoEmplacamento, String cidadeEmplacamento) {
		this.identificador = identificador;
		this.dataOcorrencia = data;
		this.periodoOcorrencia = periodoOcorrencia;
		this.logradouroEndereco = logradouro;
		this.numeroEndereco = numero;
		this.bairroEndereco = bairro;
		this.cidadeEndereco = cidade;
		this.estado = estado;
		this.anoFabricacaoVeiculo = ano;
		this.corVeiculo = cor;
		this.marcaVeiculo = marca;
		this.tipoVeiculoVeiculo = tipoVeiculo;
		this.placaEmplacamento = placa;
		this.estadoEmplacamento = estadoEmplacamento;
		this.cidadeEmplacamento = cidadeEmplacamento;
	}
	
	public BoletimFurtoVeiculo converterParaDominio() {
		BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo();
		boletim.setIdentificador(this.identificador);
		boletim.setDataOcorrencia(this.dataOcorrencia);
		boletim.setPeriodoOcorrencia(this.periodoOcorrencia);
		
		Parte parte = new Parte(this.nomeParte, this.emailParte, this.telefoneParte, this.tipoEnvolvimentoParte);
		boletim.setPartes(parte);
		
		Endereco endereco = new Endereco(this.logradouroEndereco, Integer.parseInt(this.numeroEndereco), this.bairroEndereco, this.cidadeEndereco, this.estado);
		boletim.setLocalOcorrencia(endereco);
		
		Emplacamento emplacamento = new Emplacamento(this.placaEmplacamento, this.estadoEmplacamento, this.cidadeEmplacamento);
		
		Veiculo veiculo = new Veiculo(this.anoFabricacaoVeiculo, this.corVeiculo, this.marcaVeiculo, this.tipoVeiculoVeiculo, emplacamento);
		boletim.setVeiculoFurtado(veiculo);	
		
		return boletim;
		
	}

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

	public String getNomeParte() {
		return nomeParte;
	}

	public void setNomeParte(String nomeParte) {
		this.nomeParte = nomeParte;
	}

	public String getEmailParte() {
		return emailParte;
	}

	public void setEmailParte(String emailParte) {
		this.emailParte = emailParte;
	}

	public String getTelefoneParte() {
		return telefoneParte;
	}

	public void setTelefoneParte(String telefoneParte) {
		this.telefoneParte = telefoneParte;
	}

	public String getTipoEnvolvimentoParte() {
		return tipoEnvolvimentoParte;
	}

	public void setTipoEnvolvimentoParte(String tipoEnvolvimentoParte) {
		this.tipoEnvolvimentoParte = tipoEnvolvimentoParte;
	}

	public String getLogradouroEndereco() {
		return logradouroEndereco;
	}

	public void setLogradouroEndereco(String logradouroEndereco) {
		this.logradouroEndereco = logradouroEndereco;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAnoFabricacaoVeiculo() {
		return anoFabricacaoVeiculo;
	}

	public void setAnoFabricacaoVeiculo(String anoFabricacaoVeiculo) {
		this.anoFabricacaoVeiculo = anoFabricacaoVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getTipoVeiculoVeiculo() {
		return tipoVeiculoVeiculo;
	}

	public void setTipoVeiculoVeiculo(String tipoVeiculoVeiculo) {
		this.tipoVeiculoVeiculo = tipoVeiculoVeiculo;
	}

	public String getPlacaEmplacamento() {
		return placaEmplacamento;
	}

	public void setPlacaEmplacamento(String placaEmplacamento) {
		this.placaEmplacamento = placaEmplacamento;
	}

	public String getEstadoEmplacamento() {
		return estadoEmplacamento;
	}

	public void setEstadoEmplacamento(String estadoEmplacamento) {
		this.estadoEmplacamento = estadoEmplacamento;
	}

	public String getCidadeEmplacamento() {
		return cidadeEmplacamento;
	}

	public void setCidadeEmplacamento(String cidadeEmplacamento) {
		this.cidadeEmplacamento = cidadeEmplacamento;
	}

	

	
}
