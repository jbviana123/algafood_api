package com.jbvianna.food.domain.repository;

import java.util.List;

import com.jbvianna.food.domain.model.Cozinha;

public interface CozinhaRepository {
    
	List<Cozinha> todas();
	Cozinha porId(Long id);
	Cozinha adicionar(Cozinha cozinha);
	void remover(Long id);
	void excluir(Cozinha cozinha);
	
	
}
