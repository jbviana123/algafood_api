package com.jbvianna.food.domain.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jbvianna.food.domain.exeption.EntidadeEmUsoException;
import com.jbvianna.food.domain.exeption.EntidadeNaoEncontradaException;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;
/*aqui criamos uma classe especifica para o serviço
de cadastrar uma cozinha sem ter acesso direto ao 
repositorio nessa classe colocamos regras de nego
cio que nao sao responsabilidades da classe*/

@Service
public class CadastroCozinhaService {
	/*AQUI INJETAMOS UMA COZINHA REPOSITORY*/
    @Autowired
    private CozinhaRepository cozinhaRepository;
    
	public Cozinha salvar(Cozinha cozinha) {
	    
		return cozinhaRepository.save(cozinha);
	}
	/*aqui estou fazendo o tratamento de excessoes que esta no controller*/
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			/*aqui excessao lançada quando cozinha esta em uso 
			 * e nao pode ser removida*/
		}catch(EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe um cadastro de cozinha com o codigo %d", cozinhaId));
		}catch(DataIntegrityViolationException e ) {
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d nao pode ser removida,pois esta em uso", cozinhaId));
		}
			
		
	}
}
