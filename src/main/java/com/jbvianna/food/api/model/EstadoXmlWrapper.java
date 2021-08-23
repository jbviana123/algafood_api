package com.jbvianna.food.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.jbvianna.food.domain.model.Estado;

@JacksonXmlRootElement(localName = "estados")
public class EstadoXmlWrapper {
	
	@JsonProperty("estado")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Estado> estados;
    
	
	public EstadoXmlWrapper() {
		
	}
	
	


	public EstadoXmlWrapper(List<Estado> estado) {
		super();
		this.estados = estado;
	}




	public List<Estado> getEstados() {
		return estados;
	}


	public void setCozinhas(List<Estado> estados) {
		this.estados = estados;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estados == null) ? 0 : estados.hashCode());
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
		EstadoXmlWrapper other = (EstadoXmlWrapper) obj;
		if (estados == null) {
			if (other.estados != null)
				return false;
		} else if (!estados.equals(other.estados))
			return false;
		return true;
	}
	
	
	
}
