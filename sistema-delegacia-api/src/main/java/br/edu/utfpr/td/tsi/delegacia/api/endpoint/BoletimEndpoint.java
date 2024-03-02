package br.edu.utfpr.td.tsi.delegacia.api.endpoint;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculoRep;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.RegrasBoletim;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim")
public class BoletimEndpoint {
	@Autowired
	private RegrasBoletim regrasBoletim;
	
	@QueryParam("idBoletim")
	private String idBoletim;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterBoletim() throws IOException {
		BoletimFurtoVeiculo boletim = regrasBoletim.consultar(idBoletim);
		return Response.ok(new BoletimFurtoVeiculoRep(boletim)).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarBoletim(BoletimFurtoVeiculoRep boletim) throws IOException {
		boletim.setIdentificador(idBoletim);
		BoletimFurtoVeiculo boletimDominio = boletim.converterParaDominio();
		regrasBoletim.alterar(boletimDominio);
		return Response.ok(new BoletimFurtoVeiculoRep(boletimDominio)).build();
		
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerBoletim() throws IOException {
		regrasBoletim.remover(idBoletim);
		return Response.ok("Boletim removido com sucesso").build();
	}

}
