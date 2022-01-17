package com.jbvianna.food.domain.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jbvianna.food.domain.exeption.EntidadeEmUsoException;
import com.jbvianna.food.domain.exeption.EntidadeNaoEncontradaException;
import com.jbvianna.food.domain.model.Cidade;
import com.jbvianna.food.domain.model.Estado;
import com.jbvianna.food.domain.repository.CidadeRepository;
import com.jbvianna.food.domain.repository.EstadoRepository;
@Service
public class CadastroCidadeService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	 private CidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de estado com codigo %d",estadoId)));
		
		
		cidade.setEstado(estado);
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
			
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de cidade com o codigo %d", cidadeId));
			
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de codigo %d nao pode ser removida,pois esta em uso", cidadeId));
		}
	}

}
