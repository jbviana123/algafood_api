package com.jbvianna.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jbvianna.food.domain.model.Cidade;
import com.jbvianna.food.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class)
				.getResultList();
	}

	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
    @Transactional
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}
    @Transactional
	public void remover(Cidade cidade) {
		cidade=buscar(cidade.getId());
		manager.remove(cidade);
		
	}

}
