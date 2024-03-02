package br.edu.utfpr.td.tsi.delegacia.api.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculoRep;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.RegrasBoletim;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("listaVeiculos")
public class ListaVeiculoEndpoint {
	@Autowired
	private RegrasBoletim regrasBoletim;
	
	@QueryParam("placa")
	private String placa;
	
	@QueryParam("cor")
	private String cor;
	
	@QueryParam("tipoVeiculo")
	private String tipoVeiculo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarListaBoletins() throws IOException {

		if(placa == null && cor == null && tipoVeiculo == null) {
			try {
				List<Veiculo> lista = regrasBoletim.consultarVeiculos(null, null, null);
				return Response.ok(lista).build();
			}catch(Exception e) {
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			}
		}else {
			try {
				List<Veiculo> lista = regrasBoletim.consultarVeiculos(placa, cor, tipoVeiculo);
				List<Veiculo> representacoes = new ArrayList<>();
				for(Veiculo veiculo : lista) {
					representacoes.add(veiculo);
				}
				return Response.ok(representacoes).build();
			}catch(Exception e) {
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			}
		}
		
	}
}
