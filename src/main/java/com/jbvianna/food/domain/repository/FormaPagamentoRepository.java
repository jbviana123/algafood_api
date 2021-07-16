package com.jbvianna.food.domain.repository;

import java.util.List;

import com.jbvianna.food.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
     
	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	FormaPagamento remover(FormaPagamento formaPagamento);
}
