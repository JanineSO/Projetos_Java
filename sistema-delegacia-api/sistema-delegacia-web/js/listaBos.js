var listarProcessos = function() {
    alert("entrou");
    $.ajax({
        url: "http://localhost:8080/delegacia-api/listaBoletins",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        success: function(boletins) {
			$("#loading").hide();
            limparTabela();
            $.each(boletins, function(index, bo) {   
					var novaLinha =
                    '<tr>' +
                    '<td class="org-left">' + bo.identificador + '</td>' +
                    '<td style="text-align: center">' + bo.dataOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.cidadeEndereco + '</td>' +
                    '<td style="text-align: center">' + bo.periodoOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.marcaVeiculo + '</td>' +
                    '<td style="text-align: center">' + bo.placaEmplacamento + '</td>' +
                    '<td style="text-align: center">' + bo.corVeiculo +'</td>' +
                    '</tr>';
                $("#tabelaBos tr:last").after(novaLinha);
            });
        },
        error: function() {

        }
    });
};

var listarProcessosComFiltro = function(parametro, texto) {
    var url;
    if(parametro == "identificador"){
        url = "http://localhost:8080/delegacia-api/listaBoletins?identificador="+texto;
    }else if(parametro == "cidade"){
        url = "http://localhost:8080/delegacia-api/listaBoletins?cidade="+texto;
    }else if( parametro == "periodoOcorrencia"){
        url = "http://localhost:8080/delegacia-api/listaBoletins?periodoOcorrencia="+texto;
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
                    '<td class="org-left">' + bo.identificador + '</td>' +
                    '<td style="text-align: center">' + bo.dataOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.cidadeEndereco + '</td>' +
                    '<td style="text-align: center">' + bo.periodoOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.marcaVeiculo + '</td>' +
                    '<td style="text-align: center">' + bo.placaEmplacamento + '</td>' +
                    '<td style="text-align: center">' + bo.corVeiculo +'</td>' +
                    '</tr>';
                $("#tabelaBos tr:last").after(novaLinha);
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