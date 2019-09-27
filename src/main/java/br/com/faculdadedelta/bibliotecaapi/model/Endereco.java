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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
