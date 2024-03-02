var listarProcessos = function() {
    alert("entrou");
    $.ajax({
        url: "http://localhost:8080/delegacia-api/listaVeiculos",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function(boletins) {
			$("#loading").hide();
            limparTabela();
            $.each(boletins, function(index, bo) {   
					var novaLinha =
                    '<tr>' +
                    '<td class="org-left">' + bo.anoFabricacao + '</td>' +
                    '<td style="text-align: center">' + bo.cor + '</td>' +
                    '<td style="text-align: center">' + bo.marca + '</td>' +
                    '<td style="text-align: center">' + bo.tipoVeiculo + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.placa + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.estado + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.cidade +'</td>' +
                    '</tr>';
                $("#tabelaVeiculos tr:last").after(novaLinha);
            });
        },
        error: function() {

        }
    });
};

var listarProcessosComFiltro = function(parametro, texto) {
    var url;
    if(parametro == "placa"){
        url = "http://localhost:8080/delegacia-api/listaVeiculos?placa="+texto;
    }else if(parametro == "cor"){
        url = "http://localhost:8080/delegacia-api/listaVeiculos?cor="+texto;
    }else if( parametro == "tipoVeiculo"){
        url = "http://localhost:8080/delegacia-api/listaVeiculos?tipoVeiculo="+texto;
    }
    $.ajax({
        url: url,
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function(boletins) {
			$("#loading").hide();
            limparTabela();
            $.each(boletins, function(index, bo) {   
					var novaLinha =
                    '<tr>' +
                    '<td class="org-left">' + bo.anoFabricacao + '</td>' +
                    '<td style="text-align: center">' + bo.cor + '</td>' +
                    '<td style="text-align: center">' + bo.marca + '</td>' +
                    '<td style="text-align: center">' + bo.tipoVeiculo + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.placa + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.estado + '</td>' +
                    '<td style="text-align: center">' + bo.emplacamento.cidade +'</td>' +
                    '</tr>';
                $("#tabelaVeiculos tr:last").after(novaLinha);
            });
        },
        error: function() {

        }
    });
};

var limparTabela = function() {
    $("#tabelaBos").find("tr:gt(0)").remove();
}

var consultar = function(urlContato) {
    sessionStorage.setItem("urlContato", urlContato);
    window.location.href = "consulta.html";
}

$(document).ready(function() {
    listarProcessos();    
});