package com.jbvianna.food.api.controller;

import static com.jbvianna.food.infrastructure.repository.Spec.RestauranteSpecs.comFreteGratis;
import static com.jbvianna.food.infrastructure.repository.Spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.model.Restaurante;
import com.jbvianna.food.domain.repository.CozinhaRepository;
import com.jbvianna.food.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
    
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
		
	}
	
	@GetMapping("/cozinha/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome){
		return cozinhaRepository.findByNome(nome);
		
	}
	
	@GetMapping("/cozinha/exists-por-nome")
	public boolean cozinhaExiste(
			String nome){
		return cozinhaRepository.existsByNome(nome);
	}
	
	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(
			BigDecimal taxaInicial , BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
		
	}
	
	@GetMapping("/restaurantes/por-nome-id")
	public List<Restaurante> restaurantesPorNomeId(
			String nome , Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome,cozinhaId);
		
	}
	
	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantesPorNome(
			String nome){
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restaurantesTop2PorNome(
			String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("/restaurantes/count-por-cozinha")
	public int  restaurantesCountPorCozinha(
			Long cozinhaId){
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("/restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantePorNomeFrete(
			String nome , BigDecimal taxaFreteInicial,BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome,taxaFreteInicial,taxaFreteFinal);
	}	
	
	@GetMapping("/restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratis(@RequestParam String nome ){
	
		return restauranteRepository.findAll(comFreteGratis()
				.and(comNomeSemelhante(nome)));
	}	
	
}
	
	

