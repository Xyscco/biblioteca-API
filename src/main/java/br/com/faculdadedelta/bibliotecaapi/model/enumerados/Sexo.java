package br.com.faculdadedelta.bibliotecaapi.model.enumerados;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Sexo {

	MASCULINO("Masculino"), 
	FEMININO("Feminino");

	@Getter
	private String descricao;

	
}
