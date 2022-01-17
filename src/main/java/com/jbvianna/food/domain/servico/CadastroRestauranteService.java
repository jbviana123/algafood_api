package com.jbvianna.food.domain.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbvianna.food.domain.exeption.EntidadeNaoEncontradaException;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.model.Restaurante;
import com.jbvianna.food.domain.repository.CozinhaRepository;
import com.jbvianna.food.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	@Autowired
	private RestauranteRepository restauranteRepository;
    
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId)));
		
		
		
		
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
		
	}
	
}
