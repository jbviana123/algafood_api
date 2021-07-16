package com.jbvianna.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;
@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> todas(){
		
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
		
		//pode ser assim tambem
		// return query.getResultList();
	}
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
			return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover (Cozinha cozinha) {
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}
		
}
