package com.jbvianna.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jbvianna.food.domain.model.Permissao;
import com.jbvianna.food.domain.repository.PermissaoRepository;

public class PermissaoImpl implements PermissaoRepository {
    
	
	@PersistenceContext
	private EntityManager manager;
	
	

	
	@Override
	public List<Permissao> listar() {
		return manager.createQuery("from permissao",Permissao.class)
				.getResultList();
	}

	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class,id);
	}

	@Override
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	public void remover(Permissao permissao) {
		 permissao = buscar(permissao.getId());
		 manager.remove(permissao);
	}

}
