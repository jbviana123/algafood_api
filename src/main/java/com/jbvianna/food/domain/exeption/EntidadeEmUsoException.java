package com.jbvianna.food.domain.exeption;

public class EntidadeEmUsoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	/*Criando um contrutor que recebe uma mensagem*/
	public EntidadeEmUsoException(String mensagem) {
		/*chama o construtor do rumtimexception super passando uma mensagem 
		 * que recebemos do parametro String mensagem*/
		super(mensagem);
	}
}


