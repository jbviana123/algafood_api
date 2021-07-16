package com.jbvianna.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jbvianna.food.domain.model.Estado;
import com.jbvianna.food.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoyImpl implements EstadoRepository {
    
	@PersistenceContext
	private EntityManager manager;
    @Transactional
	public List<Estado> listar() {
		return manager.createQuery("from Estado",Estado.class)
				.getResultList();
	}
    @Transactional
    @Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
    
	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}
	
    @Transactional
    @Override
	public void remover(Estado estado) {
		estado=buscar(estado.getId());
		manager.remove(estado);
	}
	
	
	
	
}
