package com.jbvianna.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.jbvianna.food.AlgafoodApiApplication;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;

public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				    .web(WebApplicationType.NONE)
				    .run(args);
				
	CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
				
				Cozinha cozinha = new Cozinha();
				cozinha.setId(1L);
				
				cozinha.setNome("Brasileira");
				cadastroCozinha.adicionar(cozinha);
			    
				

}
	
	
}
