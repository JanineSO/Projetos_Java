package br.edu.utfpr.td.tsi.delegacia.api.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.delegacia.api.endpoint.TesteEndPoint;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.BoletimNaoEncontradoExceptionHandler;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.DadosObrigatoriosExceptionHandler;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.FormatoDataExceptionHandler;
import br.edu.utfpr.td.tsi.delegacia.api.negocios.FormatoEmailExceptionHandler;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/delegacia-api")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		this.register(RequestContextFilter.class);
		this.register(TesteEndPoint.class);
		this.register(BoletimNaoEncontradoExceptionHandler.class);
		this.register(DadosObrigatoriosExceptionHandler.class);
		this.register(FormatoDataExceptionHandler.class);
		this.register(FormatoEmailExceptionHandler.class);
		this.packages("br.edu.utfpr.td.tsi.delegacia.api.endpoint");	
		this.packages("br.edu.utfpr.td.tsi.delegacia.api.config");		
	}
}