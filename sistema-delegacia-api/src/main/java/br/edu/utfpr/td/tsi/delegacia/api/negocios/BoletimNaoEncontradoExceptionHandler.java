package br.edu.utfpr.td.tsi.delegacia.api.negocios;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BoletimNaoEncontradoExceptionHandler implements ExceptionMapper<BoletimNaoEncontradoException>{
	@Override
	public Response toResponse(BoletimNaoEncontradoException exception) {
		return Response.status(Status.NOT_FOUND).entity(exception.getMessage()).build();
	}

}
