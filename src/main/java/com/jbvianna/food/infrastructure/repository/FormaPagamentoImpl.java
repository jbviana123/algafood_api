package com.jbvianna.food.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jbvianna.food.domain.model.FormaPagamento;
import com.jbvianna.food.domain.repository.FormaPagamentoRepository;
@Component
public class FormaPagamentoImpl implements FormaPagamentoRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento",FormaPagamento.class)
				.getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		return null;
	}
    
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return null;
	}
    
	@Transactional
	@Override
	public FormaPagamento remover(FormaPagamento formaPagamento) {
		return null;
	}

}
