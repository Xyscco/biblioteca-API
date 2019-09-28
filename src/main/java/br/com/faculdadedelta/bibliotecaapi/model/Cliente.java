package br.com.faculdadedelta.bibliotecaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.faculdadedelta.bibliotecaapi.model.enumerados.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do Cliente é obrigatório")
	private String nome;
	
	@NotBlank(message = "O CPF é obrigatório")
	private String cpf;
	
	@NotBlank(message = "O email do Cliente é obrigatório")
	private String email;
	
	@NotBlank(message = "O telefone do Cliente é obrigatório")
	private String telefone;
	
	@NotNull(message = "O endereco do Cliente é obrigatório")
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	private Sexo sexo;


}
