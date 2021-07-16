package com.jbvianna.food.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbvianna.food.domain.model.Cozinha;
import com.jbvianna.food.domain.repository.CozinhaRepository;
@Controller

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
    @Autowired
	private CozinhaRepository cozinhaRepository;
	
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Cozinha> listar(){
		
		return cozinhaRepository.todas();
	}
}
