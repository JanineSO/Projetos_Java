package br.edu.utfpr.td.tsi.delegacia.api.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.api.dominio.BoletimFurtoVeiculoRep;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.RegrasBoletim;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("listaBoletins")
public class ListaBoletinsEndpoint {
	@Autowired
	private RegrasBoletim regrasBoletim;
	
	@QueryParam("identificador")
	private String identificador;
	
	@QueryParam("cidade")
	private String cidade;
	
	@QueryParam("periodoOcorrencia")
	private String periodoOcorrencia;
	
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletim(BoletimFurtoVeiculoRep boletimRep) {
		try {
			BoletimFurtoVeiculo boletim = boletimRep.converterParaDominio();
			regrasBoletim.cadastrar(boletim);
			BoletimFurtoVeiculoRep boletimDominio = new BoletimFurtoVeiculoRep(boletim);
			return Response.ok(boletimDominio).build();
		}catch(Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response carregarListaBoletins() throws IOException {
//		System.out.println(cidade);
		if(identificador == null && cidade == null && periodoOcorrencia == null) {
			try {
				List<BoletimFurtoVeiculo> lista = regrasBoletim.listarTodos();
				List<BoletimFurtoVeiculoRep> representacoes = new ArrayList<>();
				for(BoletimFurtoVeiculo boletim : lista) {
					representacoes.add(new BoletimFurtoVeiculoRep(boletim));
				}
				return Response.ok(representacoes).build();
			}catch(Exception e) {
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			}
		}else {
			try {
				List<BoletimFurtoVeiculo> lista = regrasBoletim.consultarBoletins(identificador, cidade, periodoOcorrencia);
				List<BoletimFurtoVeiculoRep> representacoes = new ArrayList<>();
				for(BoletimFurtoVeiculo boletim : lista) {
					representacoes.add(new BoletimFurtoVeiculoRep(boletim));
				}
				return Response.ok(representacoes).build();
			}catch(Exception e) {
				return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
			}
		}
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarBoletim(BoletimFurtoVeiculoRep boletimRep) {
		try {
			boletimRep.setIdentificador(identificador);
			BoletimFurtoVeiculo boletim = boletimRep.converterParaDominio();
			regrasBoletim.alterar(boletim);
			return Response.ok(boletim).build();
		}catch(Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete() {
		try {
			regrasBoletim.remover(identificador);
			return Response.ok("Boletim removido").build();
		}catch(Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}
}
