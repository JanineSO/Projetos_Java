package br.edu.utfpr.td.tsi.delegacia.api.negocios;

public class BoletimNaoEncontradoException extends RuntimeException{
	public BoletimNaoEncontradoException(String msg) {
		super(msg);
	}
}
