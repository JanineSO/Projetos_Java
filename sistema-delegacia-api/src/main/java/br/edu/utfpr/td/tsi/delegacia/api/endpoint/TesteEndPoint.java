package br.edu.utfpr.td.tsi.delegacia.api.endpoint;

import org.springframework.stereotype.Component;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
@Component
@Path("teste")
public class TesteEndPoint {
	@GET
	public Response test() {
		return Response.ok("teste bem sucedido :)").build();
	}
}
