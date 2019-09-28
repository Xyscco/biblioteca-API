package br.com.faculdadedelta.bibliotecaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome da rua é obrigatório")
	private String rua;
	
	@NotBlank(message = "O nome do bairro é obrigatório")
	private String bairro;
	
	@NotBlank(message = "O numero da quadra é obrigatório")
	private String quadra;
	
	@NotBlank(message = "O nome do lote é obrigatório")
	private String lote;
	
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "O nome da cidade é obrigatório")
	private String cidade;
	
	@NotBlank(message = "O nome do estado é obrigatório")
	private String estado;
	
	private String pais;


}
