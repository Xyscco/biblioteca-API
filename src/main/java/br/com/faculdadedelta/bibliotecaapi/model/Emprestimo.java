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

}
