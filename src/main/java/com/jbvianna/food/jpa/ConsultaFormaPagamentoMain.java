package com.jbvianna.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.jbvianna.food.AlgafoodApiApplication;
import com.jbvianna.food.domain.model.FormaPagamento;
import com.jbvianna.food.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				    .web(WebApplicationType.NONE)
				    .run(args);
				FormaPagamentoRepository todasFormaPagamentos = applicationContext.getBean(FormaPagamentoRepository.class);
				
				List<FormaPagamento> todasFormasPagamentos = todasFormaPagamentos.listar();
				
				for(FormaPagamento formaPagamento : todasFormasPagamentos) {
					System.out.println(formaPagamento.getDescricao());
				}
	}

}
