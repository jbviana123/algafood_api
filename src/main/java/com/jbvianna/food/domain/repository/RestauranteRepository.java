package com.jbvianna.food.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jbvianna.food.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>,RestauranteRepositoryQueries ,
JpaSpecificationExecutor<Restaurante>{
	
//	List<Restaurante> listar();
//	Restaurante buscar(Long id);
//	Restaurante salvar(Restaurante restaurante);
//	void remover(Restaurante restaurante);
    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial,BigDecimal taxaFinal);
    
//	@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
    //List<Restaurante> findByNomeContainingAndCozinhaId(String nome,Long cozinha);
    
    Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
    List<Restaurante> findTop2ByNomeContaining(String nome);
    
   
    int countByCozinhaId(Long cozinha);
}
