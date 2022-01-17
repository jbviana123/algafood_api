package com.jbvianna.food.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jbvianna.food.api.model.CozinhasXmlWrapper;
import com.jbvianna.food.domain.exeption.EntidadeEmUsoException;
import com.jbvianna.food.domain.exeption.EntidadeNaoEncontradaException;
import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;
import com.jbvianna.food.domain.servico.CadastroCozinhaService;
@Controller

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
    @Autowired
	private CozinhaRepository cozinhaRepository;
    
    @Autowired
    private CadastroCozinhaService cadastroCozinha;
	
    @GetMapping
	public List<Cozinha> listar(){
		
		return cozinhaRepository.findAll();
	}
    
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
    	return new CozinhasXmlWrapper(cozinhaRepository.findAll());
    }
    
    
    @GetMapping("/{cozinhaId}")//@pathvariable atribui o id a variavel de nome cozinhaId no getMapping
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
    	Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
    	
    	//com o optinal evita-se o nullpointerexeption
    	//aqui fazemos um tratamento para um requisiçao inexistente 
    	//se cozinha existe
    	if(cozinha.isPresent()) {
    		//retorna ok e e a representaçao da cozinha
    		return ResponseEntity.ok(cozinha.get());
    	}
    	//caso contrario retorne notFound sem um corpo na resposta
    	return ResponseEntity.notFound().build();
    	//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	//-----------------------------------------------------------
    	//return ResponseEntity.status(HttpStatus.OK).build();//fazendo bilding automatico
    	//return ResponseEntity.ok(cozinha);
    	
    	//--fazendo mudando o redirecionamento do serviço para retornar status 302//
    	
    	//HttpHeaders headers = new HttpHeaders();
    	//headers.add(HttpHeaders.LOCATION, "http://api.algafood.localhost:8080/cozinhas");
    	//---------------------------------------------
    	//return ResponseEntity.status(HttpStatus.FOUND)
    			//.headers(headers)
    			//.build();
    	
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
    	return cadastroCozinha.salvar(cozinha);
    }
    
    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
    		/*estou pegando a cozinha que o consumidor esta 
    		 * mandando e colocando em
    		uma nova instancia no caso a cozinha atual*/
    		@RequestBody Cozinha cozinha){
    	
    	Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
    	
    	if(cozinhaAtual.isPresent()) {
    	//cozinhaAtual.setNome(cozinha.getNome());
    	
    	//este metodo esta copiando as propiedades da cozinha cozinhaAtual
    	BeanUtils.copyProperties(cozinha, cozinhaAtual.get(),"id");
    	                                               //ignora o id e nao passa 
    	Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
    	
    	return ResponseEntity.ok(cozinhaSalva);
    	}
    	return ResponseEntity.notFound().build();
    	
    	
   }
    
    @DeleteMapping("/{cozinhaId}")
	public 	ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		
    	try {
    	  cadastroCozinha.excluir(cozinhaId);
		//Cozinha cozinha = cozinhaRepository.porId(cozinhaId);
		    return ResponseEntity.noContent().build();
    
    	 /*aqui e dado erro caso nao existir uma cozinha*/
    	}catch(EntidadeNaoEncontradaException e) {
    	    return ResponseEntity.notFound().build();
    	}catch (EntidadeEmUsoException e) {
    		/*aqui erro caso a cozinha estiver em uso e nao poder remover*/
    		return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
    	
    }
    
    
    
}
