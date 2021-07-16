package com.jbvianna.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbvianna.food.domain.model.Estado;
import com.jbvianna.food.domain.repository.EstadoRepository;
@Controller
@RestController
@RequestMapping("/estados")
public class EstadoController {
     
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listarEstados(){
		
		return estadoRepository.listar();
	}
	
}
