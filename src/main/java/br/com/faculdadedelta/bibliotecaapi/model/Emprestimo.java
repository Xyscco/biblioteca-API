package br.com.faculdadedelta.bibliotecaapi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "A data do emprestimo deve ser informada!")
	private Date dataDoEmprestimo;
	
	@NotNull(message = "A data da Devolução deve ser informada!")
	private Date dataDaDevolucao;

	@NotNull(message = "O valor do emprestimo deve ser informado!")
	private BigDecimal valorDoEmprestimo;

	@NotNull(message = "O cliente deve ser informado!")
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@NotNull(message = "O livro deve ser informado")
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;

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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
