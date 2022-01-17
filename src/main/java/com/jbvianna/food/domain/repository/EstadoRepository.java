package com.jbvianna.food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbvianna.food.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
//	List<Estado> listar();
//    Estado buscar(Long id);
//    Estado salvar (Estado estado);
//    void remover(Long id);
}
