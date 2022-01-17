package com.jbvianna.food.domain.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jbvianna.food.domain.exeption.EntidadeEmUsoException;
import com.jbvianna.food.domain.exeption.EntidadeNaoEncontradaException;
import com.jbvianna.food.domain.model.Estado;
import com.jbvianna.food.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
	try {	
		estadoRepository.deleteById(estadoId);
			
	}catch(EmptyResultDataAccessException e){
		throw new EntidadeNaoEncontradaException(
				String.format("Nao existe um cadastro de estado com codigo %d", estadoId));
	}catch(DataIntegrityViolationException e) {
		throw new EntidadeEmUsoException(
				String.format("Estado de codigo %d nao pode ser removido,pois esta em uso", estadoId));
	}
	
	}
    
}
