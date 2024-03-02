var cadastrar = function(url) {
  var bo = {
	identificador: "2500/2023",
	dataOcorrencia: $("#data").val(),
	periodoOcorrencia: $("#periodo").val(),
	logradouroEndereco: $("#logradouro").val(),
	numeroEndereco: $("#numero").val(),
	bairroEndereco: $("#bairro").val(),
	cidadeEndereco: $("#cidade").val(),
	endereco: $("#estado").val(),
	placaEmplacamento: $("#placa").val(),
	cidadeEmplacamento: $("#cidadePlaca").val(),
	estadoEmplacamento: $("#estadoPlaca").val(),		
	anoFabricacaoVeiculo: $("#ano").val(),	
	corVeiculo: $("#cor").val(),	
	marcaVeiculo: $("#marca").val(),	
	tipoVeiculoVeiculo: $("#tipo").val(),
	nomeParte: $("#nome").val(),
	emailParte: $("#email").val(),
	telefoneParte: $("#telefone").val(),
	tipoEnvolvimentoParte: "Vítima"					
  };
  
  $.ajax({
    url: url,
    type: 'POST',
    async: true,
    contentType: 'application/json',
    data: JSON.stringify(bo),
    success: function(boCadastrado) {
	  alert("Boletim cadastrado com sucesso!");
	  $(location).attr('href', 'index.html');
    },
    error: function(xhr, status, error) {
      $("#resultado").empty();
      $("#resultado").append("Erro ao cadastrar: " + xhr.responseText)
    }
  });
};



$(document).ready(function() {
  $("#botaoCadastrar").click(function() {
    cadastrar("http://localhost:8080/delegacia-api/listaBoletins");
  }); 
});
