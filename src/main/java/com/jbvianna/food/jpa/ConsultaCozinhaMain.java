package com.jbvianna.food.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.jbvianna.food.AlgafoodApiApplication;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				    .web(WebApplicationType.NONE)
				    .run(args);
				CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
				
				List<Cozinha> todasCozinhas = cozinhas.todas();
				
				for(Cozinha cozinha : todasCozinhas) {
					System.out.println(cozinha.getNome());
				}
	}

}