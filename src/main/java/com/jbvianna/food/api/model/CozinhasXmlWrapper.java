package com.jbvianna.food.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.jbvianna.food.domain.model.Cozinha;

@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhasXmlWrapper {
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Cozinha> cozinhas;
    
	
	public CozinhasXmlWrapper() {
		
	}
	
	


	public CozinhasXmlWrapper(List<Cozinha> cozinhas) {
		super();
		this.cozinhas = cozinhas;
	}




	public List<Cozinha> getCozinhas() {
		return cozinhas;
	}


	public void setCozinhas(List<Cozinha> cozinhas) {
		this.cozinhas = cozinhas;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cozinhas == null) ? 0 : cozinhas.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CozinhasXmlWrapper other = (CozinhasXmlWrapper) obj;
		if (cozinhas == null) {
			if (other.cozinhas != null)
				return false;
		} else if (!cozinhas.equals(other.cozinhas))
			return false;
		return true;
	}
	
	
	
}
