package com.jbvianna.food.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jbvianna.food.domain.model.Restaurante;
import com.jbvianna.food.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
    @PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome ,BigDecimal taxaFreteInicial,
	       BigDecimal taxaFreteFinal){
		
	    //fabrica de elementos para criar nossas consultas
		var builder = manager.getCriteriaBuilder();
		
		var criteria = builder.createQuery(Restaurante.class);
		var root = criteria.from(Restaurante.class);//from Restaurante
		
		var predicates = new ArrayList<Predicate>();
		
		if (StringUtils.hasText(nome)) {
		    predicates.add(builder.like(root.get("nome"), "%" +nome +"%"));
		}
		
		if(taxaFreteInicial != null) {
		predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"),taxaFreteInicial));
		}
		
		if(taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"),taxaFreteInicial));
		}
			
		
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		
		var query = manager.createQuery(criteria);
			return query.getResultList();
		
		      
	    	       
	    	   
	    	  
	    	   
		    	   
	       }
}
