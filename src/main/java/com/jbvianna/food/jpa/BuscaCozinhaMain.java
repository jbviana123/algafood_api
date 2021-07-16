package com.jbvianna.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.jbvianna.food.AlgafoodApiApplication;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				    .web(WebApplicationType.NONE)
				    .run(args);
				CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
				
				Cozinha cozinha = cadastroCozinha.porId(1L);
				System.out.println(cozinha.getNome());
				
			    
	}

}
